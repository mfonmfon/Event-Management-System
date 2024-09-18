package com.semicolon.africa.Event_Management_System.utils;

import com.semicolon.africa.Event_Management_System.Exception.EmailAlreadyExistException;
import com.semicolon.africa.Event_Management_System.Exception.EmptyFieldsException;
import com.semicolon.africa.Event_Management_System.Exception.InvalidEmailException;
import com.semicolon.africa.Event_Management_System.data.model.Attendees;
import com.semicolon.africa.Event_Management_System.data.model.Organizer;
import com.semicolon.africa.Event_Management_System.data.repository.AttendeeRepository;
import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.LoginAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.RegisterAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.LoginAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.RegisterAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import org.springframework.beans.factory.annotation.Autowired;

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


    public static RegisterAttendeeResponse signupResponseMapper(Attendees attendees) {
        RegisterAttendeeResponse response = new RegisterAttendeeResponse();
        response.setAttendeesId(attendees.getId());
        response.setFirstName(attendees.getFirstName());
        response.setLastName(attendees.getLastName());
        response.setEmail(attendees.getEmail());
        response.setPhoneNumber(attendees.getPhoneNumber());
        response.setPassword(attendees.getPassword());
        response.setCreateAt(attendees.getCreateAt());
        response.setLoggedIn(true);
        response.setMessage("Signup Successfully");
        return response;
    }

    public static void signupRequestMapper(RegisterAttendeeRequest request, Attendees attendees) {
        attendees.setFirstName(request.getFirstName());
        attendees.setLastName(request.getLastName());
        attendees.setEmail(request.getEmail());
        attendees.setPhoneNumber(request.getPhoneNumber());
        attendees.setPassword(request.getPassword());
        attendees.setCreateAt(request.getCreateAt());
        if (isValueNullOrEmpty(request.getFirstName())||
                isValueNullOrEmpty(request.getLastName())||
                isValueNullOrEmpty(request.getPassword())||
                isValueNullOrEmpty(request.getPassword())||
                isValueNullOrEmpty(request.getPhoneNumber())){
            throw new EmptyFieldsException("Empty fields, please enter all the fields");
        }
        validateEmail(request.getEmail());
    }

    private static void validateEmail(String email) {
        if(!email.contains("@")|| !email.contains(".")||
                !email.contains(".com")){
            throw new InvalidEmailException("Invalid email");

        }
    }

    public static LoginAttendeeResponse loginAttendeeResponseMapper(LoginAttendeeResponse response, Attendees attendees) {
        response.setAttendeeId(attendees.getId());
        response.setEmail(attendees.getEmail());
        response.setPassword(attendees.getPassword());
        response.setLoggedIn(attendees.isLoggedIn());
        response.setMessage("Login successfully");
        return response;
    }

    public static void loginRequestMapper(LoginAttendeeRequest loginRequest, Attendees attendees) {
        validateEmail(loginRequest.getEmail());
        attendees.setEmail(loginRequest.getEmail());
        attendees.setPassword(loginRequest.getPassword());

    }

    private static boolean isValueNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


}
