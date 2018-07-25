package com.tum.atmsim.exception.handler;

import com.tum.atmsim.exception.AtmSimualateException;
import com.tum.atmsim.exception.InvalidRequestException;
import com.tum.atmsim.exception.ResourceNotFoundException;
import com.tum.atmsim.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidException(InvalidRequestException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setCode("Invalid Request");
        response.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotfoundException(ResourceNotFoundException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setCode("Not Found");
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AtmSimualateException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(AtmSimualateException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setCode("Unknown Error");
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
