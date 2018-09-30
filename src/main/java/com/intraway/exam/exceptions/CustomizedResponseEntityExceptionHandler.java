package com.intraway.exam.exceptions;

import com.intraway.exam.models.entity.FizzBuzz;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    FizzBuzzErrorResponse customizedErrorResponse = new FizzBuzzErrorResponse();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FizzBuzzMinIsGreaterThanMaxException.class)
    public  ResponseEntity<FizzBuzzErrorResponse> handleMinIsGreaterThanMaxException(FizzBuzzMinIsGreaterThanMaxException exception, WebRequest request) {
        customizedErrorResponse = SetExceptionInformation(this.customizedErrorResponse, exception, request);
        customizedErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        customizedErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(customizedErrorResponse,HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<FizzBuzzErrorResponse> handleNotFoundException(Exception exception, WebRequest request) {
        customizedErrorResponse = SetExceptionInformation(this.customizedErrorResponse, exception, request);
        customizedErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customizedErrorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(customizedErrorResponse, HttpStatus.NOT_FOUND);
    }

    private FizzBuzzErrorResponse SetExceptionInformation(FizzBuzzErrorResponse customizedErrorResponse, Exception ex, WebRequest request) {
        customizedErrorResponse.setTimeStamp(System.currentTimeMillis());
        customizedErrorResponse.setException(ex.getClass().toString());
        customizedErrorResponse.setMessage(ex.getMessage());
        customizedErrorResponse.setPath(request.getDescription(false));
        return customizedErrorResponse;
    }
}
