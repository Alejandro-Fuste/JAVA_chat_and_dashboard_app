package com.investing_app.customexceptions;

public class OnlyLetters extends RuntimeException {
    public OnlyLetters(String message) {
        super(message);
    }
}
