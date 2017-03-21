package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = init(reader);
        int b = init(reader);

        System.out.println(nod(a,b));
    }

    public static int init(BufferedReader reader) throws Exception {
        while (true)
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n <= 0)
                    throw new NumberFormatException();
                else
                    return n;
            } catch (IOException e) {
                System.out.println(e);
            }
    }

    public static int nod(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return nod(b, a % b);
    }
}
