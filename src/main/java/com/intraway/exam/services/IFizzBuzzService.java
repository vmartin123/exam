package com.intraway.exam.services;


import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.repositories.IFizzBuzzRepository;
import org.springframework.http.ResponseEntity;


public interface IFizzBuzzService {

    FizzBuzz calculateFizzBuzz(int min, int max) throws Exception;

}
