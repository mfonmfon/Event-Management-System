package com.semicolon.africa.Event_Management_System.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrganizersRequest {
    private String companyName;
    private String email;
    private String password;
    private String phoneNumber;
}
