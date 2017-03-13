package com.javarush.task.task12.task1226;

/* 
Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
*/

public class Solution {

    public interface Fly{
        void fly();
    }

    public interface Run{
        void run();
    }

    public interface Climb{
        void climb();
    }

    public class Cat implements Run, Climb {
        @Override
        public void climb() {

        }

        @Override
        public void run() {

        }
    }

    public class Dog implements Run{
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Run, Fly{
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
}
