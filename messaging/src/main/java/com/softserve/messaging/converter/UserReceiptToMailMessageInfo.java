package com.softserve.messaging.converter;

import com.softserve.messaging.model.EmailType;
import com.softserve.messaging.model.MailMessageInfo;
import com.softserve.messaging.model.UserReceipt;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserReceiptToMailMessageInfo implements Converter<UserReceipt, MailMessageInfo> {

    @Override
    public MailMessageInfo convert(UserReceipt userReceipt) {
        MailMessageInfo mailMessageInfo = new MailMessageInfo();

        mailMessageInfo.setEmail(userReceipt.getEmail());
        mailMessageInfo.setEmailType(EmailType.RECEIPT);
        mailMessageInfo.setFieldsSummary(userReceipt.toString());

        return mailMessageInfo;
    }
}
