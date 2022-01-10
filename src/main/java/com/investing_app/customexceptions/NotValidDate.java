package com.investing_app.customexceptions;

public class NotValidDate extends RuntimeException {
    public NotValidDate(String message) {
        super(message);
    }
}
