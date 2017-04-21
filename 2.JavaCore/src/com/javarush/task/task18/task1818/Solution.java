package com.javarush.task.task18.task1818;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        byte[] buffer = new byte[fileInputStream2.available() + fileInputStream3.available()];

        if (fileInputStream2.available() + fileInputStream3.available() > 0){
            int count = fileInputStream2.read(buffer);
            fileInputStream3.read(buffer, count, fileInputStream3.available());

            fileOutputStream.write(buffer);
        }

        reader.close();
        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();

    }
}
