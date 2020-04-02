package com.softserve.messaging.service;

import com.softserve.messaging.model.MailTemplate;

public interface MailService {

    void sendMessage(MailTemplate mailTemplate);
}
