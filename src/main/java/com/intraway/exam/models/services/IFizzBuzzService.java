package com.intraway.exam.models.services;


import com.intraway.exam.models.entity.FizzBuzz;


public interface IFizzBuzzService {

    FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzzModel);

    FizzBuzz getFizzBuzz(int min, int max);

    String CalculateMultiples(int min, int max);

    String GetDescription(String list);


}
