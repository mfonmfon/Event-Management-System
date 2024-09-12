package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.Exception.EmailAlreadyExistException;
import com.semicolon.africa.Event_Management_System.data.repository.OrganizerRepository;
import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrganizerServicesTest {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private OrganizerServices organizerServices;

    @BeforeEach
    void setUp() {
        organizerRepository.deleteAll();
    }

    @Test
    public void testThatOrganizerCanBeAdded(){
        AddOrganizersRequest request = new AddOrganizersRequest();
        request.setCompanyName("Semicolon Africa");
        request.setEmail("mfon@gmail.com");
        request.setPhoneNumber("08123115688");
        request.setPassword("12345");
        AddOrganizerResponse response = organizerServices.createOrganizer(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Added successfully");
    }

    @Test
    public void testThatWhenEmailAlreadyExist_ThrowAnException(){
        AddOrganizersRequest request = new AddOrganizersRequest();
        request.setCompanyName("Semicolon Africa");
        request.setEmail("mfon@gmail.com");
        request.setPhoneNumber("0902345678");
        request.setPassword("1234");
        AddOrganizerResponse response = organizerServices.createOrganizer(request);
        assertThat(response).isNotNull();
        request.setCompanyName("Semicolon Africa");
        request.setEmail("mfon@gmail.com");
        request.setPhoneNumber("0902345678");
        request.setPassword("1234");
        assertThat(response).isNotNull();
        assertThrows(EmailAlreadyExistException.class, ()->{
            organizerServices.createOrganizer(request);
        });
    }

    @Test
    public void testThatOrganizersCanBeUpdated(){
        UpdateOrganizerRequest request = new UpdateOrganizerRequest();
        request.setCompanyName("Uba");
        request.setEmail("fola@gmail.com");
        request.setPhoneNumber("090234");
        request.setPassword("1743");
        UpdateOrganizerResponse response = organizerServices.updateOrganizer(request);
        assertThat(response).isNotNull();
    }
}