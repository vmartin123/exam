package com.intraway.exam.exceptions.handlers;

import com.intraway.exam.exceptions.reponse_models.FizzBuzzErrorResponse;
import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    FizzBuzzErrorResponse customizedErrorResponse;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FizzBuzzMinIsGreaterThanMaxException.class)
    public  ResponseEntity<FizzBuzzErrorResponse> handleMinIsGreaterThanMaxException(FizzBuzzMinIsGreaterThanMaxException exception, WebRequest request) {
        customizedErrorResponse = SetExceptionInformation(this.customizedErrorResponse, exception, request);
        customizedErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customizedErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(customizedErrorResponse,HttpStatus.BAD_REQUEST);
    }

    private FizzBuzzErrorResponse SetExceptionInformation(FizzBuzzErrorResponse customizedErrorResponse, Exception ex, WebRequest request) {
        customizedErrorResponse.setTimeStamp(System.currentTimeMillis());
        customizedErrorResponse.setException(ex.getClass().toString());
        customizedErrorResponse.setMessage(ex.getMessage());
        customizedErrorResponse.setPath(request.getDescription(false));
        return customizedErrorResponse;
    }
}
