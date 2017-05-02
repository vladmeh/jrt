package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/


import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fn1 = args[0];
        String fn2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fn1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fn2));

        while (fileReader.ready()){
            String[] str = fileReader.readLine().split("\\s+");

            for (String s: str){
                Pattern p = Pattern.compile("[\\d]");
                Matcher m = p.matcher(s);
                try{
                    if (m.find())
                        Integer.parseInt(s);
                }
                catch (NumberFormatException e){
                    fileWriter.write(s + " ");
                }
            }
        }


        fileReader.close();
        fileWriter.close();
    }
}
