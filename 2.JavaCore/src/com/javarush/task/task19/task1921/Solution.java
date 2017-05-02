package com.javarush.task.task19.task1921;

import sun.text.resources.FormatData;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] name = line.split("\\d+");
            String date = line.replaceAll(name[0], "");

            PEOPLE.add(
                    new Person(name[0].trim(),
                    new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(date))
            );
        }

        fileReader.close();

    }
}
