package com.codeacademy.backend.service.exception;

public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {
        super(message);
    }
}
