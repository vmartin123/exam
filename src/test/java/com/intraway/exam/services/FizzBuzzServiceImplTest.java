package com.intraway.exam.services;

import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzServiceImplTest {

    IFizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();

    @Test
    void calculateFizzBuzz() {
    }

    @Test
    void GetDescriptionWithMultiplesOf3And5() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("1,2,Fizz,4,Buzz");
        String expectedResult = "Se encontraron multiplos de 3 y de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void GetDescriptionWithMultiplesOf3() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("Fizz,4");
        String expectedResult = "Se encontraron multiplos de 3";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void GetDescriptionWithMultiplesOf5() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("Buzz,6");
        String expectedResult = "Se encontraron multiplos de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void GetDescriptionWithMultiplesOf5OnSameNumber() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("1,2,Fizz,4,Buzz");
        String expectedResult = "Se encontraron multiplos de 3 y de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void GetDescriptionWithoutNumbersBeingMultiples() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("4");
        String expectedResult = "No se encontraron multiplos de ningun numero";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void CalculateMultiplesWithMultiplesOf3() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(3,4);
        String expectedResult = "Fizz,4";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void CalculateMultiplesWithMultiplesOf5() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(4,5);
        String expectedResult = "4,Buzz";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void CalculateMultiplesWithMultiplesOf3And5() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(15,15);
        String expectedResult = "FizzBuzz";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    void ValidateThanMixParameterIsLesserThanMaxArgumentWhenItFails() {
        FizzBuzzMinIsGreaterThanMaxException e = assertThrows(FizzBuzzMinIsGreaterThanMaxException.class, () ->fizzBuzzService.ValidateThanMixParameterIsLesserThanMaxArgument(100,20));
    }
    @Test
    void ValidateThanMixParameterIsLesserThanMaxArgumentWhenItFailsWithNegativeNumbers() {
        FizzBuzzMinIsGreaterThanMaxException e = assertThrows(FizzBuzzMinIsGreaterThanMaxException.class, () ->fizzBuzzService.ValidateThanMixParameterIsLesserThanMaxArgument(-100,-200));
    }

}