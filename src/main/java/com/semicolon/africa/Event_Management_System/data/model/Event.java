package com.semicolon.africa.Event_Management_System.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.model.relational.Sequence;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy =SEQUENCE)
    private Long id;
    private Long organizerId;
    private String title;
    private String description;
    private String location;
    private Long capacity;
    private EventCategory eventCategory;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long price;
    private Status status;
    @JsonFormat(pattern = "MM/DD/YY")
    private LocalDateTime createdAt;

}
