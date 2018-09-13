package com.intraway.exam.controllers;


import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.entity.FizzBuzzErrorResponse;
import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import com.intraway.exam.models.services.IFizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
@RequestMapping("/intraway/api")
public class FizzBuzzRestController {

    @Autowired
    private IFizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz/{min}/{max}")
    public FizzBuzz getFizzBuzz(@PathVariable int min, @PathVariable int max) {

        if ( min > max) {
            throw new FizzBuzzMinIsGreaterThanMaxException("Los parámetros enviados son incorrectos");
        }
        FizzBuzz fizzBuzz = new FizzBuzz();

        fizzBuzz.setTimestamp(System.currentTimeMillis());

        fizzBuzz = fizzBuzzService.persistTbenGetTheCode(fizzBuzz);

        fizzBuzz.setList(CalculateMultiples(min, max));

        fizzBuzz.setDescription(GetDescription(fizzBuzz.getList()));

        return fizzBuzz;

    }

    private String CalculateMultiples(int min, int max) {

        StringBuilder result = new StringBuilder();
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) result.append("FizzBuzz");
            else if (i % 3 == 0) result.append("Fizz");
            else if (i % 5 == 0) result.append("Buzz");
            else result.append(Integer.toString(i));

            if (i != max) result.append(",");
        }
        return result.toString();
    }

    private String GetDescription(String list) {

        String[] dividedList = list.split(",");

        if (Arrays.asList(dividedList).contains("FizzBuzz")) return "Se encontraron multiplos de 3 y de 5";
        else if (Arrays.asList(dividedList).contains("Fizz")) return "Se encontraron multiplos de 3";
        else if (Arrays.asList(dividedList).contains("Buzz"))   return "Se encontraron multiplos de 5";
        else return "No se encontraron multiplos de ningun tipo";
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
