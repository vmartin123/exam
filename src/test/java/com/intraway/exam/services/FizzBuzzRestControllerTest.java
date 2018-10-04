/*
package com.intraway.exam.services;

import com.intraway.exam.controllers.FizzBuzzRestController;
import com.jayway.jsonassert.JsonAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzRestController.class)
@AutoConfigureMockMvc
public class FizzBuzzRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateFizzBuzzWhitCorrectArguments() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/intraway/api/fizzbuzz/{min}/{max}", 1L,5L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.list", is("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz")))
                .andReturn();

    }

}
*/
