package com.investing_app.customexceptions;

public class TooLong extends RuntimeException{
    public TooLong(String message){
        super(message);
    }
}
