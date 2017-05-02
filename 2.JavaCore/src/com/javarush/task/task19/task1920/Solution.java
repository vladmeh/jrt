package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<>();

        while (fileReader.ready()){
            String[] str = fileReader.readLine().split("\\s+");
            Double salary = Double.parseDouble(str[1]);
            if (map.containsKey(str[0]))
                salary = map.get(str[0]) + salary;

            map.put(str[0], salary);
        }

        fileReader.close();

        //Находим максимальное значение в списке
        Double maxPrice = Collections.max(map.values());

        for (Map.Entry<String, Double> entry: map.entrySet()){
            if (entry.getValue().equals(maxPrice))
                System.out.println(entry.getKey());

        }
    }
}
