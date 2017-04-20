package com.javarush.task.level18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mvl on 20.04.2017.
 */
public class BufferedInputFile {
    // Throw exceptions to console:
    public static String
    read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        //Объект StringBuilder sb служит для объединения всего прочитанного текста
        // (включая переводы строк, поскольку метод readLine() их отбрасывает).
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!= null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
    public static void main(String[] args)
            throws IOException {
        System.out.print(read("D:/JavaRush/JavaRushTasks/Java4thEdition/src/com/javarush/task/level18/BufferedInputFile.java"));
    }
}
