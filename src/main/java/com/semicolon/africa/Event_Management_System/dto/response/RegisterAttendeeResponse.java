package com.semicolon.africa.Event_Management_System.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class RegisterAttendeeResponse {
    private Long attendeesId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    //    private TicketingSystem ticketingSystem;
    private boolean isLoggedIn;
    private LocalDate createAt;
    private String message;
}
