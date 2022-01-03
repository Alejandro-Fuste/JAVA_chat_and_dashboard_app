package dev.java_investing_app.customexceptions;

public class BusinessNotFound extends RuntimeException {
    public BusinessNotFound(String message){
        super(message);
    }
}
