package com.landeros.customexceptions;

public class UsernameOrPasswordIncorrect extends RuntimeException{
    public UsernameOrPasswordIncorrect(String message) {
        super(message);
    }
}
