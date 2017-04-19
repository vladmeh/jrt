package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        //Программа должна три раза считать имена файлов с консоли.
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        //Для чтения из файла используй поток FileInputStream,
        FileInputStream file1 = new FileInputStream(fileName1);
        //для записи в файлы - FileOutputStream
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);

        //Если файл не пустой
        if (file1.available() > 0){
            //читаем весь файл одним куском в переменную
            byte[] buffer = new byte[file1.available()];
            int count = file1.read(buffer);

            //count - количествo реально прочитанных байт, в принципе == file1.available()
            //если количество байт нечетное, то при делении на 2 округление идет в меньшую сторону

            //во второй файл записываем большую половину
            file2.write(buffer, 0, count - (count/2));
            //в третий файл записываем остаток со смещением из buffer на большу половину
            file3.write(buffer, count - (count/2), count/2);
        }

        //Потоки FileInputStream и FileOutputStream должны быть закрыты.
        file1.close();
        file2.close();
        file3.close();
    }
}
