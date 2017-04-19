package com.javarush.task.task18.tests;

import java.io.*;

/**
 * Created by mvl on 19.04.2017.
 */
public class FileInputOutputBlock {
    public static void main(String[] args) throws Exception
    {
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream("d:/JavaRush/test2.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("d:/JavaRush/result2.txt");

        byte[] buffer = new byte[1024];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
