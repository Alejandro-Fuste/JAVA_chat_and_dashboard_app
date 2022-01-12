package com.investing_app.customexceptions;

public class CreateCommentException extends RuntimeException{
    public CreateCommentException(String message){
        super(message);
    }
}
