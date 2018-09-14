package com.intraway.exam.models.repositories;

import com.intraway.exam.models.entity.FizzBuzz;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FizzBuzzRepositoryImpl implements IFizzBuzzRepository{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzz) {

        em.persist(fizzBuzz);
        em.flush();
        fizzBuzz.setCode(fizzBuzz.getId());
        return fizzBuzz;
    }






}
