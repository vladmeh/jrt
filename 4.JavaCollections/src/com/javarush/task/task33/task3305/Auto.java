package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike"),
        @JsonSubTypes.Type(value = RaceBike.class, name = "race-bike")
})

public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}