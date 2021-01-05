package com.codeacademy.backend.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private LocalDateTime timestamp;
}
