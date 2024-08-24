package com.yahia.rest_crud.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler
    ResponseEntity<StudentError> handleException(StudentNotFoundException ex) {
        StudentError error = new StudentError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<StudentError> GenericHandler(Exception ex) {
        StudentError error = new StudentError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
