package com.javarush.task.level23;

/**
 * Вызов конструктора базового класса.
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Вызов конструктора базового класса:
        return new Wrapping(x) { // // аргумент конструктора.
            public int value() {
                return super.value() * 47;
            }
        }; // // Требуется точка с запятой
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.getClass().getCanonicalName());
        System.out.println(w.value());
    }
}
