package com.example.vuelos.exceptions;

public class DuplicateDocumentException extends RuntimeException{
    public DuplicateDocumentException() {}

    public DuplicateDocumentException(String message) {
        super(message);
    }
}
