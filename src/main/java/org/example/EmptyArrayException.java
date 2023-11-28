package org.example;

public class EmptyArrayException extends Exception {
    public EmptyArrayException() {
    }

    public EmptyArrayException(String message) {
        super(message);
    }
}
