package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        String result = "";
        int intValueOfChar;
        if (reader != null){
            StringBuilder stringBuilder = new StringBuilder();
            while ((intValueOfChar = reader.read()) != -1){
                stringBuilder.append((char) (intValueOfChar + key));
            }
            result = stringBuilder.toString();
        }

        return result;
    }

}
