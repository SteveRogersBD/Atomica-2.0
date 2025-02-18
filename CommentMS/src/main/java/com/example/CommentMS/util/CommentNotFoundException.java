package com.example.CommentMS.util;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message) {
        super(message);
    }
    public CommentNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
}
