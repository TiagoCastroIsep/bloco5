package org.example;

public class EmptyArrayException extends NullPointerException {
    public EmptyArrayException() {
    }

    public EmptyArrayException(String message) {
        super(message);
    }
}
