package com.intraway.exam.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fizzbuzzes")
public class FizzBuzz {

    public  FizzBuzz () {}

    @JsonIgnore
    @Id
    private ObjectId id;

    private Long timestamp;

    private String code;

    @JsonIgnore
    private Integer firstNumberPassed;

    @JsonIgnore
    private Integer secondNumberPassed;

    private String description;

    private String list;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(Integer id) {
        this.code =  Integer.toString(id);
    }

    public Integer getFirstNumberPassed() {
        return firstNumberPassed;
    }

    public void setFirstNumberPassed(Integer firstNumberPassed) {
        this.firstNumberPassed = firstNumberPassed;
    }

    public Integer getSecondNumberPassed() {
        return secondNumberPassed;
    }

    public void setSecondNumberPassed(Integer secondNumberPassed) {
        this.secondNumberPassed = secondNumberPassed;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
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
