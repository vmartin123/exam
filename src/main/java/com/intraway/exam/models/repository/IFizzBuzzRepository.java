package com.intraway.exam.models.repository;

import com.intraway.exam.models.entity.FizzBuzz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFizzBuzzRepository extends MongoRepository<FizzBuzz, ObjectId> {

}
