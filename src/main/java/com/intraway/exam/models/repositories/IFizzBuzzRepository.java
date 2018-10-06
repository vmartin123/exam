package com.intraway.exam.models.repositories;

import com.intraway.exam.models.entity.FizzBuzz;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IFizzBuzzRepository extends MongoRepository<FizzBuzz, String> {

}
