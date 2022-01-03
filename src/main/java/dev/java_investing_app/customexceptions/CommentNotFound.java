package dev.java_investing_app.customexceptions;

public class CommentNotFound extends RuntimeException{
    public CommentNotFound(String message){
        super(message);
    }
}
