package com.javarush.task.level23;

/**
 * Вложение класса в тело метода.
 *
 */
public class Parcel5 {
    public Destination destination(String s) {
        //класс PDestination является частью метода destination(), а не частью класса Раrсеl5.
        // Поэтому доступ к классу PDestination возможен только из метода destination().
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }
}
