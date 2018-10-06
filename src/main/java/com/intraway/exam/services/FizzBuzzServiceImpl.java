package com.intraway.exam.services;

import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.repositories.IFizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class FizzBuzzServiceImpl implements IFizzBuzzService {

    @Autowired
    private IFizzBuzzRepository fizzBuzzRepository;

    public FizzBuzz calculateFizzBuzz(int min, int max)  {

        if(ValidateThanMixParameterIsLesserThanMaxArgument(min, max));

        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setTimestamp(System.currentTimeMillis());
        fizzBuzz.setList(CalculateMultiples(min, max));
        fizzBuzz.setDescription(GetDescription(fizzBuzz.getList()));
        fizzBuzz.setFirstNumberPassed(min);
        fizzBuzz.setSecondNumberPassed(max);
        fizzBuzzRepository.save(fizzBuzz);
        fizzBuzz.setCode(fizzBuzz.getId().getCounter());
        return fizzBuzz;
    }

    public boolean ValidateThanMixParameterIsLesserThanMaxArgument(int min, int max) {

        if ( min > max) throw new FizzBuzzMinIsGreaterThanMaxException("Los parámetros enviados son incorrectos");
        return true;
    }

    public String CalculateMultiples(int min, int max) {

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

    public String GetDescription(String list) {

        String[] dividedList = list.split(",");

        if (Arrays.asList(dividedList).contains("Fizz") && Arrays.asList(dividedList).contains("Buzz")) return "Se encontraron multiplos de 3 y de 5";
        else if (Arrays.asList(dividedList).contains("FizzBuzz"))   return "Se encontraron multiplos de 3 y 5";
        else if (Arrays.asList(dividedList).contains("Fizz")) return "Se encontraron multiplos de 3";
        else if (Arrays.asList(dividedList).contains("Buzz"))   return "Se encontraron multiplos de 5";
        else return "No se encontraron multiplos de ningun numero";
    }
}
