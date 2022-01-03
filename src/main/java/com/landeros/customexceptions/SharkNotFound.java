package com.landeros.customexceptions;

public class SharkNotFound extends RuntimeException{
    public SharkNotFound(String message) {
        super(message);
    }
}
