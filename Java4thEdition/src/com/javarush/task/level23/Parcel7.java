package com.javarush.task.level23;

import java.util.Arrays;

/**
 * Метод возвращает экземпляр безымянного внутреннего класса
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {// Вставить определение класса
            private int i = 11;
            public int value() { return i; }
        };  // В данной ситуации точка с запятой необходима
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.getClass().getCanonicalName());
        System.out.println(c.value());
    }
}
