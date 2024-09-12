package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;

public interface OrganizerServices {

    AddOrganizerResponse createOrganizer(AddOrganizersRequest request);

    UpdateOrganizerResponse updateOrganizer(UpdateOrganizerRequest request);
}
