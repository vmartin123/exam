package com.intraway.exam.controllers;

import com.intraway.exam.models.entity.FizzBuzz;
import com.intraway.exam.services.IFizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/intraway/api/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
public class FizzBuzzRestController {

    @Autowired
    private IFizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz/{min}/{max}")
    public FizzBuzz calculateFizzBuzz(@PathVariable int min, @PathVariable int max) throws Exception {
        return fizzBuzzService.calculateFizzBuzz(min, max);
    }

}
