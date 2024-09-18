package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.HostEventRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.HostEventResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import org.hibernate.sql.Delete;

public interface OrganizerServices {

    AddOrganizerResponse createEvent(AddOrganizersRequest request);

    UpdateOrganizerResponse updateEvent(UpdateOrganizerRequest request);

    HostEventResponse hostEvent(HostEventRequest request);
}
