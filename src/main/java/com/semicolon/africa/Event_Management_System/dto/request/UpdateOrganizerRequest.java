package com.semicolon.africa.Event_Management_System.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrganizerRequest {
    private String companyName;
    private String email;
    private String phoneNumber;
    private String password;
}
