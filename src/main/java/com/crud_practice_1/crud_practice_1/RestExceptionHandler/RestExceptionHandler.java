package com.crud_practice_1.crud_practice_1.RestExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crud_practice_1.crud_practice_1.entity.StudentNotFound;
import com.crud_practice_1.crud_practice_1.exceptions.NotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(NotFoundException exc) {
        StudentNotFound studentNotFound = new StudentNotFound(HttpStatus.NOT_FOUND.value(), exc.getMessage(), 23322);
        return new ResponseEntity<>(studentNotFound, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> exceptionHandler(Exception exc) {
        StudentNotFound studentNotFound = new StudentNotFound(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), 23322);
        return new ResponseEntity<>(studentNotFound, HttpStatus.BAD_REQUEST);
    }
}
