package com.semicolon.africa.Event_Management_System.web;

import com.semicolon.africa.Event_Management_System.Services.OrganizerServices;
import com.semicolon.africa.Event_Management_System.data.model.Organizer;
import com.semicolon.africa.Event_Management_System.dto.request.AddOrganizersRequest;
import com.semicolon.africa.Event_Management_System.dto.request.UpdateOrganizerRequest;
import com.semicolon.africa.Event_Management_System.dto.response.AddOrganizerResponse;
import com.semicolon.africa.Event_Management_System.dto.response.ApiResponse;
import com.semicolon.africa.Event_Management_System.dto.response.UpdateOrganizerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizer")
@RequiredArgsConstructor
public class OrganizerController {

    @Autowired
    private OrganizerServices organizerServices;

    @PostMapping("/addOrganizer")
    public ResponseEntity<?> addOrganizer(@RequestBody AddOrganizersRequest request){
        try {
            AddOrganizerResponse response = organizerServices.createEvent(request);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updateOrganizer")
    public ResponseEntity<?> updateOrganizer(@RequestBody UpdateOrganizerRequest request){
        try {
            UpdateOrganizerResponse response = organizerServices.updateEvent(request);
            return new ResponseEntity<>(new ApiResponse(true, response),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
