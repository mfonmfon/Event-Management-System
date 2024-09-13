package com.semicolon.africa.Event_Management_System.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}

