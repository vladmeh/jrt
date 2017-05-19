package JavaBasics;

/**
 * 256 Целочисленные объекты создаются в диапазоне от -128 до 127,
 * которые хранятся в массиве Integer.
 * Поэтому при создании объекта с использованием Integer.valueOf
 * или непосредственного присвоения значения Integer в диапазоне от -128 до 127
 * будет возвращен тот же объект.
 *
 * Ответ - true true
 */
public class Test6 {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);
        System.out.println(i1 == 10);
    }
}
