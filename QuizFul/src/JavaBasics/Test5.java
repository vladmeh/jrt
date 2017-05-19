package JavaBasics;

/**
 * 256 Целочисленные объекты создаются в диапазоне от -128 до 127,
 * которые хранятся в массиве Integer.
 * Поэтому при создании объекта с использованием Integer.valueOf
 * или непосредственного присвоения значения Integer в диапазоне от -128 до 127
 * будет возвращен тот же объект.
 *
 * Ответ - true
 */
public class Test5 {
    public static void main(String[] args) {
        Integer i = 10;
        Integer x = 10;
        if (x == i) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
