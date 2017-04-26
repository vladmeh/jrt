package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new TreeMap<>();

        String fileName = reader.readLine();

        while (true){
            fileName = reader.readLine();
            if (fileName.equals("end")) break;

            Integer index = Integer.parseInt(fileName.substring(fileName.lastIndexOf("part")+4));
            map.put(index, fileName);
        }

        reader.close();

        System.out.println(fileName);

        //FileOutputStream resultFile = new FileOutputStream("lion.txt");

        for (Map.Entry<Integer, String> entry: map.entrySet()){

            System.out.println(entry.getKey() + " => " + entry.getValue());
            /*FileInputStream partFile = new FileInputStream(entry.getValue());
            byte[] buffer = new byte[partFile.available()];
            partFile.read(buffer);
            resultFile.write(buffer);

            partFile.close();*/
        }

        //resultFile.close();
    }
}
