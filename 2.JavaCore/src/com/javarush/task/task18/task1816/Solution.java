package com.javarush.task.task18.task1816;

/* 
Английские буквы

В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int coutn = 0;
        //пока есть еще непрочитанные байты
        while (inputStream.available() > 0){
            // прочитать очередной байт в переменную data
            int data = inputStream.read();
            // преобразовываем считанный байт в строковую переменную
            String s = String.valueOf((char)data);
            // сравниваем строковую переменную с шаблоном regex утилитой Pattern
            if (Pattern.matches("[a-zA-Z]", s))
                coutn++;
        }
        //закрываем поток
        inputStream.close();

        System.out.println(coutn);
    }
}
