package com.intraway.exam.services;

import org.junit.Test;
import static org.junit.Assert.*;

public class FizzBuzzServiceImplTest {

    private FizzBuzzServiceImpl fizzBuzzService = new FizzBuzzServiceImpl();

    @Test
    public void persistTbenGetTheCode() {
    }

    @Test
    public void getFizzBuzz() {
    }

    @Test
    public void calculateMultiples() {
       String actualResult = fizzBuzzService.CalculateMultiples(1,15);
       String expectedResult = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";
       assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateMultiplesWhenMinAndMaxAreEquals() {
        String actualResult = fizzBuzzService.CalculateMultiples(15,15);
        String expectedResult = "FizzBuzz";
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateMultiplesWhenParametersAreEmpty() {

    }

    @Test
    public void checkIfMinParameterisGreaterThanMaxParameterOngetFizzBuzzMethod() {


    }
    @Test
    public void getDescription() {
    }
}