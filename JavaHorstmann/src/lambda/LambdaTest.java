package lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @autor mvl on 01.06.2017.
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));

        //Обычная сортировка строкового массива
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        //Сортировка строкового массива по длине строки с помощью лямбда-выражения
        System.out.println("Sorted by length:");
        //Arrays.sort(planets, (first, second) -> first.length()-second.length());
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));

        //через каждую секунду показывает текущее время и дату
        Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        t.start();

        // выполнять программу до тех пор пока пользователь
        // не выберет кнопку "OK"
        JOptionPane.showMessageDialog(null, "Quit programm?");
        System.exit(0);
    }
}
