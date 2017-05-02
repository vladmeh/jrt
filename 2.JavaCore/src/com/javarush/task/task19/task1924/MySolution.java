package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mvl on 02.05.2017.
 */
public class MySolution {
    public static void main(String[] args) throws IOException {
        String fn1 = args[0];
        String fn2 = args[1];

        ArrayList<String> list = new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(fn1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fn2));

        while (fileReader.ready()){
            list.addAll(Arrays.asList(fileReader.readLine().split("\\s+")));
        }
        fileReader.close();

        for (String s: list){
            if (s.length() > 6){
                fileWriter.write(s);
                if (!s.equals(list.get(list.size()-1)))
                    fileWriter.write(",");
            }
        }
        fileWriter.close();
    }
}
