package com.investing_app.customexceptions;

public class NoValueException extends RuntimeException{
    public NoValueException(String message){
        super(message);
    }
}
