package com.semicolon.africa.Event_Management_System.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class TicketingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long eventId;
    private String firstName;
    private String lastName;
    private String price;
    private String ticketType;
    private LocalDateTime validTime;
    private LocalDateTime validUntil;
}
