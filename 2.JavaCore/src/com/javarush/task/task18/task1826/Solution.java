package com.javarush.task.task18.task1826;

/* 
Шифровка

Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("-e"))
            encode(args[1], args[2]);

        if (args.length > 0 && args[0].equals("-d"))
            decode(args[1], args[2]);
    }

    private static void encode(String fileInName, String fileOutname) throws IOException {
        FileInputStream fis = new FileInputStream(fileInName);
        FileOutputStream fos = new FileOutputStream(fileOutname);

        //Если файл не существует создаем его
        if (!new File(fileOutname).exists() )
            new File(fileOutname).createNewFile();

        //Читаем файл по-байтно
        while (fis.available() > 0)
            //Для "шифрования" записываем в исходный файл прибавляя к каждому байту 1
            fos.write(fis.read()+1);

        fis.close();
        fos.close();
    }

    private static void decode(String fileInName, String fileOutname) throws IOException {
        FileInputStream fis = new FileInputStream(fileInName);
        FileOutputStream fos = new FileOutputStream(fileOutname);

        //Если файл не существует создаем его
        if (!new File(fileOutname).exists() )
            new File(fileOutname).createNewFile();

        //Читаем файл по-байтно
        while (fis.available() > 0)
            //Для "дешифрвки" записываем в исходный файл отнимая у каждого байта 1
            fos.write(fis.read()-1);

        fis.close();
        fos.close();
    }
}
