package com.intraway.exam.models.services;

import com.intraway.exam.exceptions.FizzBuzzMinIsGreaterThanMaxException;
import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.entity.FizzBuzzErrorResponse;
import com.intraway.exam.models.repositories.IFizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@Service
public class FizzBuzzServiceImpl implements IFizzBuzzService {

    @Autowired
    private IFizzBuzzRepository fizzBuzzRepository;

    @Override
    @Transactional
    public FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzzModel) {return fizzBuzzRepository.persistTbenGetTheCode(fizzBuzzModel); }

    public FizzBuzz getFizzBuzz(int min, int max) {

        if ( min > max) {
            throw new FizzBuzzMinIsGreaterThanMaxException("Los parámetros enviados son incorrectos");
        }
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.setTimestamp(System.currentTimeMillis());
        fizzBuzz = persistTbenGetTheCode(fizzBuzz);
        fizzBuzz.setList(CalculateMultiples(min, max));
        fizzBuzz.setDescription(GetDescription(fizzBuzz.getList()));
        return fizzBuzz;
    }

    public String CalculateMultiples(int min, int max) {

        StringBuilder result = new StringBuilder();
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) result.append("FizzBuzz,");
            else if (i % 3 == 0) result.append("Fizz,");
            else if (i % 5 == 0) result.append("Buzz,");
            else result.append(Integer.toString(i));

            if (i != max) result.append(",");
        }
        return result.toString();
    }

    public String GetDescription(String list) {

        String[] dividedList = list.split(",");

        if (Arrays.asList(dividedList).contains("FizzBuzz")) return "Se encontraron multiplos de 3 y de 5";
        else if (Arrays.asList(dividedList).contains("Fizz")) return "Se encontraron multiplos de 3";
        else if (Arrays.asList(dividedList).contains("Buzz"))   return "Se encontraron multiplos de 5";
        else return "No se encontraron multiplos de ningun tipo";
    }



}
