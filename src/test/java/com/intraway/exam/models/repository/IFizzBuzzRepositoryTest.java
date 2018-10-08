package com.intraway.exam.models.repository;

import com.intraway.exam.models.entity.FizzBuzz;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IFizzBuzzRepositoryTest {

    @Autowired
    private IFizzBuzzRepository fizzBuzzRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void getRequestsToFizzBuzzApi() {

        fizzBuzzRepository.deleteAll();
    }

    @Test
    public void CalculateFizzBuzzRestControllerTestWithAllKindOfMultiplesOf3And5() throws Exception {

        getRequestMockMvc(1,15);
        getRequestMockMvc(5,30);
        getRequestMockMvc(25,55);
        getRequestMockMvc(40,60);
        getRequestMockMvc(10,33);
        getRequestMockMvc(3,15);

        List<FizzBuzz> fizzBuzzes = fizzBuzzRepository.findAll();
        
        assertEquals(6, fizzBuzzes.size());
        assertTrue(validateNullFields(fizzBuzzes));
    }

    private void getRequestMockMvc(int min, int max) throws Exception {

        this.mockMvc.perform(get("/intraway/api/fizzbuzz/{min}/{max}", min, max));
    }

    private boolean validateNullFields(List<FizzBuzz> fizzBuzzes) {

        for(FizzBuzz fizzBuzz: fizzBuzzes) {
           if(fizzBuzz.getId() == null) return false;
           else if (fizzBuzz.getTimestamp() == null) return false;
           else if (fizzBuzz.getFirstNumberPassed() == null) return false;
           else if (fizzBuzz.getSecondNumberPassed() == null) return false;
           else if (fizzBuzz.getDescription() == null) return false;
           else if (fizzBuzz.getList() == null) return false;
        }
        return true;
    }
}