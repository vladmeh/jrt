package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String fullName, address, telephone, rank;
        private int age;
        private char sex;


        public Human(String fullName){
            this.fullName = fullName;
        }

        public Human(String firstName, String lastName, int age){
            this.fullName = firstName + " " + lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, String address){
            this.fullName = firstName + " " + lastName;
            this.address = address;
        }

        public Human(String name, String lastName, int age, String rank){
            this.fullName = name + " " + lastName;
            this.age = age;
            this.rank = rank;
        }

        public Human(String fullName, String dob){
            this.fullName = fullName;
            this.age = LocalDate.now().getYear() - LocalDate.parse(dob).getYear();
        }

        public Human(String fullName, String city, String street, int house, int apatrament){
            this.fullName = fullName;
            this.address = city + ", " + street + ", дом " + house + " кв. " + apatrament;
        }

        public Human(String fullName, char sex, int age){
            this.fullName = fullName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String fullName, char sex, int age, String address, String telephone){
            this.fullName = fullName;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.telephone = telephone;
        }

        public Human(String fullName, char sex, int age, String rank){
            this.fullName = fullName;
            this.sex = sex;
            this.age = age;
            this.rank = rank;
        }

        public Human(String fullName, char sex, int age, String address, String telephone, String rank){
            this.fullName = fullName;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.telephone = telephone;
            this.rank = rank;
        }
    }
}
