package com.intraway.exam.services;


import com.intraway.exam.models.entity.FizzBuzz;


public interface IFizzBuzzService {

    FizzBuzz calculateFizzBuzz(int min, int max) throws Exception;
    String CalculateMultiples(int min, int max) throws Exception;
    boolean ValidateThanMixParameterIsLesserThanMaxArgument(int min, int max) throws Exception;
    String GetDescription(String list) throws Exception;
}
