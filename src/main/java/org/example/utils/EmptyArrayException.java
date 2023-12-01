package org.example.utils;

public class EmptyArrayException extends NullPointerException {
    public EmptyArrayException() {
    }

    public EmptyArrayException(String message) {
        super(message);
    }
}
