package com.semicolon.africa.Event_Management_System.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginAttendeeRequest {
    private Long attendeeId;
    private String email;
    private String password;
}
