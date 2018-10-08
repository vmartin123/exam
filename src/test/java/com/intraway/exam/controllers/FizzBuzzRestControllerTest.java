package com.intraway.exam.controllers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @org.junit.Test
    public void CalculateFizzBuzzRestControllerTestWithAllKindOfMultiplesOf3And5() throws Exception {

        performMockMvcRequestAndThenAssertTheResponse(1,15,
                "[\"1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz\"]",
                "[\"Se encontraron multiplos de 3 y de 5\"]");
    }

    @org.junit.Test
    public void CalculateFizzBuzzRestControllerTestWitOnlyMultiplesOf3() throws Exception {

        performMockMvcRequestAndThenAssertTheResponse(1,3,
                "[\"1,2,Fizz\"]",
                "[\"Se encontraron multiplos de 3\"]");
    }

    @org.junit.Test
    public void CalculateFizzBuzzRestControllerTestWitOnlyMultiplesOf5() throws Exception {

        performMockMvcRequestAndThenAssertTheResponse(4,5,
                "[\"4,Buzz\"]",
                "[\"Se encontraron multiplos de 5\"]");
    }

    @org.junit.Test
    public void CalculateFizzBuzzRestControllerTestWithMinParameterLesserThanMaxParameter() throws Exception {

        performMockMvcRequestAndThenAssertTheExpectedException(5,-2);
    }

    private void performMockMvcRequestAndThenAssertTheResponse(int min, int max, String listFieldExpectedResult, String descriptionFieldExpectedResult ) throws Exception {

        this.mockMvc.perform(get("/intraway/api/fizzbuzz/{min}/{max}", min, max))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    AssertFizzBuzzListFieldResponse(mvcResult, listFieldExpectedResult);
                    AssertFizzBuzzDescriptionFieldResponse(mvcResult, descriptionFieldExpectedResult);
                });
    }

    private void performMockMvcRequestAndThenAssertTheExpectedException(int min, int max) throws Exception {

        this.mockMvc.perform(get("/intraway/api/fizzbuzz/{min}/{max}", min, max))
                .andExpect(status().is(400))
                .andDo(mvcResult -> {
                    AssertFizzBuzzBadRequestException(mvcResult, min, max);
                });
    }

    private void AssertFizzBuzzDescriptionFieldResponse(MvcResult result, String expectedResult) throws Exception {

        DocumentContext context = JsonPath.parse(getJsonResponse(result));
        String actualResult = context.read("$..description").toString();
        assertEquals(expectedResult , actualResult);
    }

    private void AssertFizzBuzzListFieldResponse(MvcResult result, String expectedResult) throws Exception {

        DocumentContext context = JsonPath.parse(getJsonResponse(result));
        String actualResult = context.read("$..list").toString();
        assertEquals(expectedResult , actualResult);
    }

    private void AssertFizzBuzzBadRequestException(MvcResult result, int min, int max) throws Exception {

        DocumentContext context = JsonPath.parse(getJsonResponse(result));

        String actualResult;
        String expectedResult;

        //Probando mensaje de error

        actualResult = context.read("$..error").toString();
        expectedResult = "[\"Bad Request\"]";
        assertEquals(expectedResult , actualResult);

        //Probando campo exception

        actualResult = context.read("$..exception").toString();
        expectedResult = "[\"com.intraway.exam.exceptions.badrequestexception\"]";
        assertEquals(expectedResult , actualResult);

        //Probando campo message

        actualResult = context.read("$..message").toString();
        expectedResult = "[\"Los parámetros enviados son incorrectos\"]";
        assertEquals(expectedResult , actualResult);

        //Probando el campo path

        actualResult = context.read("$..path").toString();
        expectedResult = String.format("[\"uri=\\/intraway\\/api\\/fizzbuzz\\/%d\\/%d\"]", min, max);
        assertEquals(expectedResult , actualResult);
    }

    private String getJsonResponse(MvcResult result) throws Exception {

        return result.getResponse().getContentAsString();
    }


}