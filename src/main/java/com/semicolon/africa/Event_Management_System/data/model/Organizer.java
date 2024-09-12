package com.semicolon.africa.Event_Management_System.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.lang.annotation.Documented;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter

public class Organizer {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    private String companyName;
    private String email;
    private String password;
    private String phoneNumber;
}
