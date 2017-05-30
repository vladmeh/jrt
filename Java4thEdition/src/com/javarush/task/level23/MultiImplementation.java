package com.javarush.task.level23;

/**
 * При использовании реальных или абстрактных классов
 * "множественное наследование реализации" возможно
 * только с применением внутренних классов
 */

class D {}
abstract class E {}

class Z extends D {
    E makeE() { return new E() {}; }
}

public class MultiImplementation {
    static void takesD(D d) {}
    static void takesE(E e) {}
    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
