package com.example.rest.exception;

public class UserAlreadyExist extends Exception{
    public UserAlreadyExist(String message) {
        super(message);
    }
}
