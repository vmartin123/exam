package com.intraway.exam.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "fizzbuzz")
public class FizzBuzz {

    public  FizzBuzz () {}

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "request_date")
    private long timestamp;

    private String code;

    @JsonIgnore
    @Column(name = "first_number_passed")
    private int firstNumberPassed;

    @JsonIgnore
    @Column(name = "second_number_passed")
    private int secondNumberPassed;



    @Column(name = "description")
    private String description;

    @Column(name="query_result")
    private String list;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(long id) {
        this.code = "00" + Long.toString(id);
    }

    public int getFirstNumberPassed() {
        return firstNumberPassed;
    }

    public void setFirstNumberPassed(int firstNumberPassed) {
        this.firstNumberPassed = firstNumberPassed;
    }

    public int getSecondNumberPassed() {
        return secondNumberPassed;
    }

    public void setSecondNumberPassed(int secondNumberPassed) {
        this.secondNumberPassed = secondNumberPassed;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
