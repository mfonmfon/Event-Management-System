package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.data.repository.AttendeeRepository;
import com.semicolon.africa.Event_Management_System.dto.request.LoginAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.request.RegisterAttendeeRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.LoginAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.LogoutAttendeeResponse;
import com.semicolon.africa.Event_Management_System.dto.response.RegisterAttendeeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AttendeeServiceTest {

    @Autowired
    private AttendeeRepository attendeeRepository;
    @Autowired
    private AttendeeService attendeeService;

    @BeforeEach
    void setUp() {
        attendeeRepository.deleteAll();
    }

    @Test
    void signup() {
        RegisterAttendeeRequest request = registerRequest();
        RegisterAttendeeResponse response = attendeeService.signup(request);
        assertTrue(response.isLoggedIn());
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Signup Successfully");
    }

    private static RegisterAttendeeRequest registerRequest() {
        RegisterAttendeeRequest request = new RegisterAttendeeRequest();
        request.setFirstName("Kalu");
        request.setLastName("Obinna");
        request.setEmail("obina@gmail.com");
        request.setPhoneNumber("09012345654");
        request.setPassword("12211");
        return request;
    }

    @Test
    void login() {
        registerRequest();
        RegisterAttendeeResponse response = attendeeService.signup(registerRequest());
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Signup Successfully");
        LoginAttendeeRequest request = loginAttendeeRequest();
        LoginAttendeeResponse response1 = attendeeService.login(request);
        assertThat(response1).isNotNull();
        assertThat(response1.getMessage()).contains("Login successfully");
    }

    private static LoginAttendeeRequest loginAttendeeRequest() {
        LoginAttendeeRequest request = new LoginAttendeeRequest();
        request.setEmail("obina@gmail.com");
        request.setPassword("121212");
        return request;
    }

    @Test
    void logout() {
        registerRequest();
        RegisterAttendeeResponse response = attendeeService.signup(registerRequest());
        assertThat(response).isNotNull();
        loginAttendeeRequest();
        LoginAttendeeResponse login = attendeeService.login(loginAttendeeRequest());
        assertThat(login).isNotNull();

    }

    @Test
    void buyTicket() {

    }
}