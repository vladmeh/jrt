package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке

1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по-отдельности в List lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        FileInputStream file = null;
        try {
            file = new FileInputStream(Statics.FILE_NAME);
            Scanner in = new Scanner(file, "UTF-8");

            while (in.hasNext())
                lines.add(in.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
