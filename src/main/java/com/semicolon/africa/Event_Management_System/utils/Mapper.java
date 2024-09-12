package com.semicolon.africa.Event_Management_System.utils;

import com.semicolon.africa.Event_Management_System.Exception.EmptyFieldsException;
import com.semicolon.africa.Event_Management_System.data.model.Organizer;
import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;

public class Mapper {

    public static void addOrganizerRequestMapper(AddOrganizersRequest request, Organizer organizer) {
        organizer.setCompanyName(request.getCompanyName());
        organizer.setEmail(request.getEmail());
        organizer.setPhoneNumber(request.getPhoneNumber());
        organizer.setPassword(request.getPassword());
        if (valueIsNullOrEmpty(request.getCompanyName())){
            throw new EmptyFieldsException("Empty fields, please enter your company name");
        }
        if (valueIsNullOrEmpty(request.getEmail())){
            throw new EmptyFieldsException("Empty fields, please enter your email");
        }
        if (valueIsNullOrEmpty(request.getPhoneNumber())){
            throw new EmptyFieldsException("Empty fields, please enter your phone number");
        }
        if (valueIsNullOrEmpty(request.getPassword())){
            throw new EmptyFieldsException("Empty fields, please enter your password");
        }
    }

    private static boolean valueIsNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


    public static AddOrganizerResponse addOrganizerResponseMapper(Organizer organizer) {
        AddOrganizerResponse response = new AddOrganizerResponse();
        response.setOrganizerId(organizer.getId());
        response.setCompanyName(organizer.getCompanyName());
        response.setEmail(organizer.getEmail());
        response.setPhoneNumber(organizer.getPhoneNumber());
        response.setPassword(organizer.getPassword());
        response.setMessage("Added successfully");
        return response;
    }
    public static void updateRequestMapper(UpdateOrganizerRequest request, Organizer organizer) {
        organizer.setCompanyName(request.getCompanyName());
        organizer.setEmail(request.getEmail());
        organizer.setPhoneNumber(request.getPhoneNumber());
        organizer.setPassword(request.getPassword());
        if (valueIsNullOrEmpty(request.getCompanyName())){
            throw new EmptyFieldsException("Empty fields, please enter your company name");
        }
        if (valueIsNullOrEmpty(request.getEmail())){
            throw new EmptyFieldsException("Empty fields, please enter your email");
        }
        if (valueIsNullOrEmpty(request.getPhoneNumber())){
            throw new EmptyFieldsException("Empty fields, please enter your phone number");
        }
        if (valueIsNullOrEmpty(request.getPassword())){
            throw new EmptyFieldsException("Empty fields, please enter your password");
        }
    }

    public static UpdateOrganizerResponse updateOrganizerResponseMapper(Organizer organizer) {
        UpdateOrganizerResponse response = new UpdateOrganizerResponse();
        response.setCompanyName(organizer.getCompanyName());
        response.setEmail(organizer.getEmail());
        response.setPhoneNumber(organizer.getPhoneNumber());
        response.setPassword(organizer.getPassword());
        response.setMessage("Updated successfully");
        return response;
    }


}
