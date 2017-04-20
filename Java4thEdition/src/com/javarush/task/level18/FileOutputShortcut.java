package com.javarush.task.level18;

/**
 * Created by mvl on 20.04.2017.
 */

import java.io.*;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\com\\javarush\\task\\level18\\FileOutputShortcut.java")));
        // Сокращенная запись:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
        // Вывод содержимого файла:
        System.out.println(BufferedInputFile.read(file));
    }
}
