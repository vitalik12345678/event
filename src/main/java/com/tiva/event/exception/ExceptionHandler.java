package com.tiva.event.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException (AuthenticationException e,WebRequest request) {
        return exceptionBuilder(e,HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<?> exceptionBuilder (Exception e, HttpStatus httpStatus) {
        ExceptionDetails details = ExceptionDetails.builder()
                .HTTPCODE(httpStatus.value())
                .HTTPSTATUS(httpStatus)
                .MESSAGE(e.getMessage())
                .build();
        return new ResponseEntity<>(details,httpStatus);
    }

}
