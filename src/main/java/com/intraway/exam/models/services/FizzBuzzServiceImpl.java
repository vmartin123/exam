package com.intraway.exam.models.services;

import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.models.repositories.IFizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FizzBuzzServiceImpl implements IFizzBuzzService {

    @Autowired
    private IFizzBuzzRepository fizzBuzzRepository;

    @Override
    @Transactional
    public FizzBuzz persistTbenGetTheCode(FizzBuzz fizzBuzzModel) {return fizzBuzzRepository.persistTbenGetTheCode(fizzBuzzModel); }


}
