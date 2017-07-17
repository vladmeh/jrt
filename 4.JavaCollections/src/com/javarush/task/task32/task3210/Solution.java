package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile rof = new RandomAccessFile(fileName, "rw");

        byte[] bytes = new byte[text.length()];
        rof.seek(number);
        rof.read(bytes, 0, bytes.length);

        rof.seek(rof.length());

        if (text.equals(convertByteToString(bytes))){
            rof.write("true".getBytes());
        }
        else {
            rof.write("false".getBytes());
        }

        rof.close();
    }

    public static String convertByteToString(byte readBytes[]){
        return new String(readBytes);
    }
}
