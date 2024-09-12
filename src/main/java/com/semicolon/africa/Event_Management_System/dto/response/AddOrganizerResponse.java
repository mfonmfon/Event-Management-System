package com.semicolon.africa.Event_Management_System.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrganizerResponse {
    private Long organizerId;
    private String companyName;
    private String email;
    private String password;
    private String phoneNumber;
    private String message;
}
