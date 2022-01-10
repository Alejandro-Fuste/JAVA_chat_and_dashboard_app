package com.investing_app.customexceptions;

public class OnlyNumbers extends RuntimeException {
    public OnlyNumbers(String message) {
        super(message);
    }
}
