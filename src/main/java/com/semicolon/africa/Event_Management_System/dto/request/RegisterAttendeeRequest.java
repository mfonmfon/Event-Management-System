package com.semicolon.africa.Event_Management_System.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RegisterAttendeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    //    private TicketingSystem ticketingSystem;
    private boolean isLoggedIn;
    private LocalDate createAt;
}
