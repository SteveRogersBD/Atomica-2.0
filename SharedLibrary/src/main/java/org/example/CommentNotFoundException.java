package org.example;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message,Throwable cause) {
        super(message,cause);
    }
    public CommentNotFoundException(String message) {
        super(message);
    }
}
