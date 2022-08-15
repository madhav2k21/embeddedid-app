package com.techleads.app.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class UserDefinitionControllerAdvice {


    @ExceptionHandler(value = {UserDefinitionNotFoundException.class})
    public ResponseEntity<StandardError> handleUserNotFoundException(UserDefinitionNotFoundException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(), request.getRequestURI());
        return new ResponseEntity<>(standardError, HttpStatus.BAD_REQUEST);
    }
}
