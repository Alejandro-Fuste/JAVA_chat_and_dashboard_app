package dev.java_investing_app.customexceptions;

public class UsernameOrPasswordError extends RuntimeException{
    public UsernameOrPasswordError(String message){
        super(message);
    }
}
