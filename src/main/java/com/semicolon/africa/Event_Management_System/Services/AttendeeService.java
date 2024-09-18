package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.dto.request.LoginAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.LogoutAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.PurchaseTicketRequest;
import com.semicolon.africa.Event_Management_System.dto.request.RegisterAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.response.LoginAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.LogoutAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.PurchaseTicketResponse;
import com.semicolon.africa.Event_Management_System.dto.response.RegisterAttendeeResponse;

public interface AttendeeService {

    RegisterAttendeeResponse signup(RegisterAttendeeRequest request);

    LoginAttendeeResponse login(LoginAttendeeRequest loginRequest);

    LogoutAttendeeResponse logout(LogoutAttendeeRequest logoutRequest);

    PurchaseTicketResponse buyTicket(PurchaseTicketRequest request);





}
