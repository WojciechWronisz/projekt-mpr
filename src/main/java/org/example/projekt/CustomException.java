package org.example.projekt;

public abstract class CustomException extends RuntimeException {
    private String message;
    private String code;
    private String description;
}
