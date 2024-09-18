package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.Exception.AttendeesIdNotFoundException;
import com.semicolon.africa.Event_Management_System.Exception.EmailAlreadyExistException;
import com.semicolon.africa.Event_Management_System.data.model.Attendees;
import com.semicolon.africa.Event_Management_System.data.repository.AttendeeRepository;
import com.semicolon.africa.Event_Management_System.dto.request.LoginAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.LogoutAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.PurchaseTicketRequest;
import com.semicolon.africa.Event_Management_System.dto.request.RegisterAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.response.LoginAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.LogoutAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.PurchaseTicketResponse;
import com.semicolon.africa.Event_Management_System.dto.response.RegisterAttendeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.semicolon.africa.Event_Management_System.utils.Mapper.*;

@Service
public class AttendeeServiceImpl implements AttendeeService{
    @Autowired
    private  AttendeeRepository attendeeRepository;

    @Override
    public RegisterAttendeeResponse signup(RegisterAttendeeRequest request) {
        Attendees attendees = new Attendees();
        validateEmail(request.getEmail());
        signupRequestMapper(request, attendees);
        attendees =  attendeeRepository.save(attendees);
        return signupResponseMapper(attendees);
    }
    @Override
    public LoginAttendeeResponse login(LoginAttendeeRequest loginRequest) {
        Attendees attendees = findAttendeesById(loginRequest.getAttendeeId());
        loginRequestMapper(loginRequest, attendees);
        attendeeRepository.save(attendees);
        LoginAttendeeResponse response = new LoginAttendeeResponse();
        return loginAttendeeResponseMapper(response, attendees);
    }

    private Attendees findAttendeesById(Long id) {
        return attendeeRepository.findAttendeeById(id).
                orElseThrow(()-> new AttendeesIdNotFoundException("Attendee Id Not Found"));
    }

    @Override
    public LogoutAttendeeResponse logout(LogoutAttendeeRequest logoutRequest) {
        return null;
    }

    @Override
    public PurchaseTicketResponse buyTicket(PurchaseTicketRequest request) {
        Attendees attendees = new Attendees();
        return null;
    }

    private void validateEmail(String email) {
        for (Attendees attendees: attendeeRepository.findAll())
            if (attendees.getEmail().equals(email)){
                throw new EmailAlreadyExistException("Email Already exist");
            }
    }
}
