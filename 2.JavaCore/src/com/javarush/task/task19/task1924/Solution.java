package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел

1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map, которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Scanner in = new Scanner(new FileReader(fileName));

        //считываем весь файл в строку
        //добавляем переносы
        String file = "";
        while (in.hasNext()){
            String line = in.nextLine();
            file += line + "\n";
        }
        //закрываем поток
        in.close();

        //шаблон - цифра + пробел - это исключит слова в которых есть цифры
        Pattern pattern = Pattern.compile("\\d+\\s");
        Matcher matcher = pattern.matcher(file);

        while (matcher.find()){
            //переводим строковое число, обрезая пробел
            int n = Integer.parseInt(matcher.group().trim());
            //находим в списке соответствующее строковое значение числу
            if (map.containsKey(n)){
                //возвращаем пробел на место
                String forReplace = map.get(n) + " ";
                //меняем в тексте найденную цифру на текст
                file = file.substring(0, matcher.start())+ forReplace + file.substring(matcher.end());
                //обновляем текст в паттерне
                matcher = pattern.matcher(file);
            }
        }

        System.out.println(file);
    }
}
