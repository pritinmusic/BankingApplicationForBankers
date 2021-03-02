package com.pratiksha.demo.exception;


import com.pratiksha.demo.model.Response;
import com.pratiksha.demo.utility.CommonProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Response> errorHandler(Exception exception){
        Response response =new Response();
        response.setType(CommonProperties.ERROR_TYPE);
        response.setMessage(exception.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<Response> errorHandlingAPiException(ApiException exception){
        Response response =new Response();
        response.setType(CommonProperties.ERROR_TYPE);
        response.setMessage(exception.getErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Response> errorHandlingAPiException(ConstraintViolationException exception){
        Response response =new Response();
        response.setType(CommonProperties.ERROR_TYPE);
        response.setMessage(exception
                .getConstraintViolations()
                .stream()
                .map(message->message.getMessageTemplate())
                .findFirst()
                .get());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


//validation in entity level
}
