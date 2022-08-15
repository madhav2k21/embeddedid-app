package com.techleads.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StandardError {

    private LocalDateTime timestamp;
    private int statusCode;
    private String message;
    private String path;
}
