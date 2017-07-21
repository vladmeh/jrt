package json.lect04.task03;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Cat.class, name="cat"),
        @JsonSubTypes.Type(value=Dog.class, name="dog")
})
class Pet
{
    public String name;
}

class Cat extends Pet
{
    public int age;
}

class Dog extends Pet
{
    public int age;
    public String owner;
}

class House
{
    public List<Pet> pets = new ArrayList();
}