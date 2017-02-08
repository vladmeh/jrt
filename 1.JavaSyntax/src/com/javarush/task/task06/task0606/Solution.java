package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = reader.readLine().toCharArray();

        for ( char c: arr) {
            int n = Character.getNumericValue (c);
            if (n % 2 == 0)
                even++;
            else
                odd++;
        }

        int a = even;
        int b = odd;

        System.out.println("Even: "+ a +" Odd: " + b);
    }
}
