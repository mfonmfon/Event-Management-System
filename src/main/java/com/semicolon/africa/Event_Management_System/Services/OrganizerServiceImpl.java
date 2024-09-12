package com.semicolon.africa.Event_Management_System.Services;

import com.semicolon.africa.Event_Management_System.Exception.EmailAlreadyExistException;
import com.semicolon.africa.Event_Management_System.Exception.EmptyFieldsException;
import com.semicolon.africa.Event_Management_System.Exception.IdNotFoundException;
import com.semicolon.africa.Event_Management_System.data.model.Organizer;
import com.semicolon.africa.Event_Management_System.data.repository.OrganizerRepository;
import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.Event_Management_System.utils.Mapper.*;

@Service
public class OrganizerServiceImpl implements OrganizerServices{

    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public AddOrganizerResponse createOrganizer(AddOrganizersRequest request) {
        validateEmail(request.getEmail());
        Organizer organizer = new Organizer();
        addOrganizerRequestMapper(request, organizer);
        organizer = organizerRepository.save(organizer);
        return addOrganizerResponseMapper(organizer);
    }
    private void validateEmail(String email) {
        for(Organizer organizer: organizerRepository.findAll()){
            if (organizer.getEmail().equals(email)){
                throw new EmailAlreadyExistException("Email already exist");
            }
        }
    }
    @Override
    public UpdateOrganizerResponse updateOrganizer(UpdateOrganizerRequest request) {
        validateEmail(request.getEmail());
        Organizer organizer = findOrganizerByEmail(request.getEmail());
        organizer = organizerRepository.save(organizer);
        updateRequestMapper(request, organizer);
        return updateOrganizerResponseMapper(organizer);
    }

    private Organizer findOrganizerByEmail(String email) {
        return organizerRepository.findOrganizerByEmail(email).
                orElseThrow(()-> new IdNotFoundException("Id Not Found"));
    }
}
