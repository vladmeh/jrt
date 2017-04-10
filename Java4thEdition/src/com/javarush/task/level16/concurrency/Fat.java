package com.javarush.task.level16.concurrency;

/**
 * Объекты, создание которых занимает много времени.
 */
public class Fat {
    private volatile double d; // Предотвращает оптимизацию
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
        // Затратная, прервываемая операция:
        for(int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double)i;
        }
    }
    public void operation() { System.out.println(this); }
    public String toString() { return "Fat id: " + id; }
}
