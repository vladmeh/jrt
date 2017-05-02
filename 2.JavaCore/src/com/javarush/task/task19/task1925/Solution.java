package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fn1 = args[0];
        String fn2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fn1));
        String fileString = "";
        while (fileReader.ready()){
            fileString += fileReader.readLine() + " ";
        }
        fileReader.close();

        String[] str = fileString.split("\\s+");
        String result = "";

        for (String s: str){
            if (s.length() > 6)
                result += s + " ";
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fn2));
        fileWriter.write(result.trim().replaceAll(" ", ","));
        fileWriter.close();
    }
}
