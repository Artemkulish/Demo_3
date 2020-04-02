package com.softserve.messaging.converter;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.model.MailMessageInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MailMessageInfoToMailMessageInfoDto implements Converter<MailMessageInfo, MailMessageInfoDto> {

    @Override
    public MailMessageInfoDto convert(MailMessageInfo mailMessageInfo) {
        MailMessageInfoDto mailMessageInfoDto = new MailMessageInfoDto();

        mailMessageInfoDto.setEmail(mailMessageInfo.getEmail());
        mailMessageInfoDto.setEmailType(mailMessageInfo.getEmailType());
        mailMessageInfoDto.setFieldsSummary(mailMessageInfo.getFieldsSummary());

        return mailMessageInfoDto;
    }
}
