package com.webteam.laptopmall.exception;

public class UserLoginNotFoundException extends RuntimeException{
    public UserLoginNotFoundException(String message) {
        super(message);
    }
}
