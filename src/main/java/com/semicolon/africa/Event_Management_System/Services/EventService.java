package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.data.model.Event;
import com.semicolon.africa.Event_Management_System.dto.request.AddEventRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddEventResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventService{
    AddEventResponse createEvent(AddEventRequest request);


}
