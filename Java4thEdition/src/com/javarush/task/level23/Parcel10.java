package com.javarush.task.level23;

/**
 * Демонстрация "инициализации экземпляра" для
 * конструирования безымянного внутреннего класса
 */
public class Parcel10 {
    // Если параметры переменной используются напрямую внутри безымянного класса
    // то они должны быть объявлены неизменными (final)
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            // Инициализация экземпляра для каждого объекта:
            {
                cost = Math.round(price);
                if(cost > 100)
                    System.out.println("Over budget!");
            }
            private String label = dest;
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
        System.out.println(d.readLabel());
    }
}
