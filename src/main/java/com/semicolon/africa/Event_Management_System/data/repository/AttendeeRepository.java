package com.semicolon.africa.Event_Management_System.data.repository;

import com.semicolon.africa.Event_Management_System.data.model.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendeeRepository extends JpaRepository<Attendees, Long> {
   Optional<Attendees> findAttendeeById(Long id);


}
