package com.semicolon.africa.Event_Management_System.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;
    private String companyName;
    private String email;
    private String password;
    private String phoneNumber;
    @OneToMany
    private List<Event> listOfEvent;
}
