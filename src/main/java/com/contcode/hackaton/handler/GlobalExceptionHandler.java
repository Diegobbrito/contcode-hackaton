package com.contcode.hackaton.handler;

import com.contcode.hackaton.repository.exception.StockExistsException;
import com.contcode.hackaton.repository.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StockExistsException.class)
    public ResponseEntity<String> handleStockExistsException(StockExistsException ex) {
        return new ResponseEntity<>("Stock already exists", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(StockExistsException ex) {
        return new ResponseEntity<>("Stock not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

