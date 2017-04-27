package com.javarush.task.task19.task1906;

/* 
Четные байты

Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.

Пример:
второй байт, четвертый байт, шестой байт и т.д.

Закрыть потоки ввода-вывода.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileIn = reader.readLine();
        String foleOut = reader.readLine();

        reader.close();

        FileReader fileReader = new FileReader(fileIn);
        FileWriter fileWriter = new FileWriter(foleOut);

        int count = 0;
        while (fileReader.ready()){
            int data = fileReader.read();
            count++;
            if (count % 2 == 0)
                fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
