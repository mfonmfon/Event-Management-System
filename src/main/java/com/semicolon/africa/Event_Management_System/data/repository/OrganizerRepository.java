package com.semicolon.africa.Event_Management_System.data.repository;

import com.semicolon.africa.Event_Management_System.data.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository  extends JpaRepository<Organizer, Long> {


    Optional<Organizer> findOrganizerByEmail(String email);
}
