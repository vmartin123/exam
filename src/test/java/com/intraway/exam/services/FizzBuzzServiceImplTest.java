package com.intraway.exam.services;

import com.intraway.exam.exceptions.BadRequestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceImplTest {

    @Autowired
    private IFizzBuzzService fizzBuzzService;;

    @Test
    public void GetDescriptionWithMultiplesOf3And5() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("1,2,Fizz,4,Buzz");
        String expectedResult = "Se encontraron multiplos de 3 y de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void GetDescriptionWithMultiplesOf3() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("Fizz,4");
        String expectedResult = "Se encontraron multiplos de 3";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void GetDescriptionWithMultiplesOf5() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("Buzz,6");
        String expectedResult = "Se encontraron multiplos de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void GetDescriptionWithMultiplesOf5OnSameNumber() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("1,2,Fizz,4,Buzz");
        String expectedResult = "Se encontraron multiplos de 3 y de 5";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void GetDescriptionWithoutNumbersBeingMultiples() throws Exception {
        String actualResult = fizzBuzzService.GetDescription("4");
        String expectedResult = "No se encontraron múltiplos de ningun numero";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void CalculateMultiplesWithMultiplesOf3() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(3,4);
        String expectedResult = "Fizz,4";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void CalculateMultiplesWithMultiplesOf5() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(4,5);
        String expectedResult = "4,Buzz";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void CalculateMultiplesWithMultiplesOf3And5() throws Exception {
        String actualResult = fizzBuzzService.CalculateMultiples(15,15);
        String expectedResult = "FizzBuzz";
        assertEquals(expectedResult , actualResult);
    }

    @Test
    public void ValidateThanMixParameterIsLesserThanMaxArgumentWhenItFails() {
        assertThrows(BadRequestException.class, () ->fizzBuzzService.ValidateThanMixParameterIsLesserThanMaxArgument(100,20));
    }
    @Test
    public void ValidateThanMixParameterIsLesserThanMaxArgumentWhenItFailsWithNegativeNumbers() {
        assertThrows(BadRequestException.class, () ->fizzBuzzService.ValidateThanMixParameterIsLesserThanMaxArgument(-100,-200));
    }

}