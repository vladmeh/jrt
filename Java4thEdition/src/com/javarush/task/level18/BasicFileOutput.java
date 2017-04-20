package com.javarush.task.level18;

/**
 * Created by mvl on 20.04.2017.
 */

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\com\\javarush\\task\\level18\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        //Когда данные входного потока исчерпываются, метод readLine() возвращает null.
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        // Для потока out явно вызывается метод close();
        // если не вызвать его для всех выходных файловых потоков,
        // в буферах могут остаться данные, и файл получится неполным.
        out.close();
        // Вывод содержимого файла
        System.out.println(BufferedInputFile.read(file));
    }
}
