package com.landeros.customexceptions;

public class PitchNotFound extends RuntimeException{
    public PitchNotFound(String message) {
        super(message);
    }
}
