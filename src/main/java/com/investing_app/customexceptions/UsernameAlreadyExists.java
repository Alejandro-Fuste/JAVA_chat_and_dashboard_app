package com.investing_app.customexceptions;

public class UsernameAlreadyExists extends RuntimeException{
    public UsernameAlreadyExists(String message) {
        super(message);
    }
}
