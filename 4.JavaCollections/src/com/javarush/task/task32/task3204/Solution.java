package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            //digits
            byteArrayOutputStream.write(48 + random.nextInt(10));
            //low case
            byteArrayOutputStream.write(65 + random.nextInt(26));
        }
        for (int i = 0; i < 2; i++) {
            byteArrayOutputStream.write(97 + random.nextInt(26));
        }
        return byteArrayOutputStream;
    }


}