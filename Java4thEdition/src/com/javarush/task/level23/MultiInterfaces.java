package com.javarush.task.level23;

/**
 * Два способа реализации нескольких интерфейсов.
 */

interface A {}
interface B {}

class X implements A, B {}

class Y implements A {
    B makeB() {
        // Безымянный внутренний класс:
        return new B() {};
    }
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
