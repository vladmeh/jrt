package json.lect04.task02;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
class Pet
{
    public String name;
}

@JsonAutoDetect
class Cat extends Pet
{
    public int age;
}

@JsonAutoDetect
class Dog extends Pet
{
    public int age;
    public String owner;
}