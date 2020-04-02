package com.softserve.messaging.model;

import lombok.Data;

@Data
public class MailTemplate {

    private String mail;
    private String topic;
    private String body;
}
