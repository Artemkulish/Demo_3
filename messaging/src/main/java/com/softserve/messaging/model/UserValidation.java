package com.softserve.messaging.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "email")
public class UserValidation {

    private String email;
    private String verificationPath;
}
