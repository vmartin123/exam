package com.intraway.exam.models.repositories;

import com.intraway.exam.models.entity.FizzBuzz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IFizzBuzzRepository  {

    public FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzz);
}
