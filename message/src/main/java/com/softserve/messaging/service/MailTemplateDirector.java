package com.softserve.messaging.service;

import com.softserve.messaging.model.MailTemplate;
import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.util.UtilMailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailTemplateDirector {

    private final UtilMailMessage utilMailMessage;

    public MailTemplate createReceiptTemplate(UserReceipt userReceipt) {
        MailTemplate mailTemplate = new MailTemplate();

        mailTemplate.setMail(userReceipt.getEmail());
        mailTemplate.setTopic(utilMailMessage.getReceiptTopic());
        mailTemplate.setBody(utilMailMessage.getReceiptBody(userReceipt));

        return mailTemplate;
    }

    public MailTemplate createVerificationTemplate(UserValidation userValidation) {
        MailTemplate mailTemplate = new MailTemplate();

        mailTemplate.setMail(userValidation.getEmail());
        mailTemplate.setTopic(utilMailMessage.getVerificationTopic());
        mailTemplate.setBody(utilMailMessage.getVerificationBody(userValidation));

        return mailTemplate;
    }
}
