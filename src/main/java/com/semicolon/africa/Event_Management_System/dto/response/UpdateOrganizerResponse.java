package com.semicolon.africa.Event_Management_System.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrganizerResponse {
    private String companyName;
    private String  email;
    private String phoneNumber;
    private String password;
    private String message;
}
