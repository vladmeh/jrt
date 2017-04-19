package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);


        if (file1.available() > 0){
            //создаем массив размером  ==  размеру читаемого файла
            byte[] buffer = new byte[file1.available()];
            //читаем файл одним блоком в переменную buffer
            file1.read(buffer);
            //перебираем массив байтов 1 файла в обратном порядке
            for (int i = buffer.length - 1; i >=0 ; i--) {
                //записываем во второй файл по-байтно
                file2.write(buffer[i]);
            }
        }

        file1.close();
        file2.close();
    }
}
