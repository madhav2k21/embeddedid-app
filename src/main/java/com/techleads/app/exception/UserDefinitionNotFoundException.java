package com.techleads.app.exception;

public class UserDefinitionNotFoundException extends RuntimeException{
    public UserDefinitionNotFoundException() {
        super();
    }
    public UserDefinitionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public UserDefinitionNotFoundException(String message) {
        super(message);
    }
    public UserDefinitionNotFoundException(Throwable cause) {
        super(cause);
    }
}
