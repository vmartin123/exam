package com.intraway.exam.models.repositories;

import com.intraway.exam.models.entity.FizzBuzz;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class FizzBuzzRepositoryImpl implements IFizzBuzzRepository{

    @PersistenceContext
    private EntityManager em;

    public FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzz) {
        em.persist(fizzBuzz);
        em.flush();
        fizzBuzz.setCode(fizzBuzz.getId());
        return fizzBuzz;
    }






}
