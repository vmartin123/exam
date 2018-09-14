package com.intraway.exam.controllers;

import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.entity.FizzBuzzErrorResponse;
import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import com.intraway.exam.models.services.IFizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/intraway/api")
public class FizzBuzzRestController {

    @Autowired
    private IFizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz/{min}/{max}")
    public FizzBuzz getFizzBuzz(@PathVariable int min, @PathVariable int max) {
        return fizzBuzzService.getFizzBuzz(min, max);
    }

    @ExceptionHandler
    public ResponseEntity<FizzBuzzErrorResponse> handleException(FizzBuzzMinIsGreaterThanMaxException exception) {

        FizzBuzzErrorResponse error = new FizzBuzzErrorResponse();

        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setException(exception.getClass().toString());
        error.setMessage(exception.getMessage());
        error.setPath("Esto no se de donde mierda sacarlo");

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
