package com.investing_app.customexceptions;

public class NotEnoughChars extends RuntimeException {
    public NotEnoughChars(String message) {
        super(message);
    }
}
