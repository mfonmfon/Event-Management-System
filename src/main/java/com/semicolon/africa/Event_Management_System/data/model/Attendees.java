package com.semicolon.africa.Event_Management_System.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Attendees {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isLoggedIn;
    private LocalDate createAt;
}
