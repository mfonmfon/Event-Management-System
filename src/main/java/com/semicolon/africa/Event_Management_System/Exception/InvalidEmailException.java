package com.semicolon.africa.Event_Management_System.Exception;

public class InvalidEmailException  extends  RuntimeException{
    public InvalidEmailException(String message){
        super(message);
    }
}
