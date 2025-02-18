package com.example.PostMS.util;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
    public PostNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
}
