package com.semicolon.africa.Event_Management_System.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginAttendeeResponse {
    private Long attendeeId;
    private String email;
    private String password;
    private String message;
    private boolean isLoggedIn;
}
