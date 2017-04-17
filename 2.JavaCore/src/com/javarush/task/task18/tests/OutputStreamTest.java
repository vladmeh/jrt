package com.javarush.task.task18.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by mvl on 17.04.2017.
 */
public class OutputStreamTest {
    public static void main(String[] args) {
        //Вывод строки на консоль
        System.out.println("Hello1");

        //Сохранили поток вывода на консоль в отдельную переменную.
        //Выводим в поток строку.
        PrintStream console = System.out;
        console.println("Hello2");

        //Создали динамический (растягивающийся) массив байт в памяти.
        //Связали его с новым потоком вывода – объектов PrintStream
        //Выводим в поток строку.
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream console2 = new PrintStream(stream);
        console2.println("Hello3");
    }
}
