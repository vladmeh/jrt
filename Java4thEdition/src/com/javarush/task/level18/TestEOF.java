package com.javarush.task.level18;

import java.io.*;

/**
 * Проверка достижения конца файла одновременно
 * с чтением из него по байту.
 *
 * Метод available() работает по-разному в зависимости от источника данных;
 * дословно его функция описывается следующим образом:
 * «количество байтов, которые можно прочитать без блокировки».
 * При чтении из файла это означает весь файл, но для другого рода потоков
 * это не обязательно верно
 */
public class TestEOF {
    public static void main(String[] args)
            throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\com\\javarush\\task\\level18\\TestEOF.java")));
        while(in.available() != 0)
            System.out.print((char)in.readByte());
    }
}
