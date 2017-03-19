package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        BufferedWriter writer = new BufferedWriter(fileWriter);

        while (true){
            String string = reader.readLine();
            writer.write(string + System.lineSeparator());
            if (string.equals("exit"))
                break;
        }

        reader.close();
        writer.close();
        fileWriter.close();
    }
}
