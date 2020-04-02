package com.softserve.messaging.kafka;

import com.softserve.messaging.controller.MessagingClient;
import com.softserve.messaging.model.MailTemplate;
import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.service.MailMessageInfoService;
import com.softserve.messaging.service.MailService;
import com.softserve.messaging.service.MailTemplateDirector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final MailService mailService;
    private final MailTemplateDirector mailTemplateDirector;
    private final MailMessageInfoService mailMessageInfoService;
    private final MessagingClient messagingClient;

    @Value("${service-token}")
    private String bearerToken;

    @KafkaListener(topics = "email-receipt")
    public void listenMailReceipt(UserReceipt userReceipt) {
        log.info("Received user receipt");

        UserReceipt missingUserInfo =
                messagingClient.getMissingUserInfo("Bearer " + bearerToken, userReceipt.getUserId());
        userReceipt.setEmail(missingUserInfo.getEmail());
        userReceipt.setFirstName(missingUserInfo.getFirstName());

        MailTemplate mailTemplate = mailTemplateDirector.createReceiptTemplate(userReceipt);
        mailService.sendMessage(mailTemplate);

        mailMessageInfoService.saveUserReceipt(userReceipt);
    }

    @KafkaListener(topics = "email-verification")
    public void listenMailVerification(UserValidation userValidation) {
        log.info("Received user verification");

        MailTemplate mailTemplate = mailTemplateDirector.createVerificationTemplate(userValidation);
        mailService.sendMessage(mailTemplate);

        mailMessageInfoService.saveUserValidation(userValidation);
    }
}