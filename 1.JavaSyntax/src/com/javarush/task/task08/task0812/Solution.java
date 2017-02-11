package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int len = 1;
        int max = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i-1))
                len++;

            if (len > max && list.get(i) != list.get(i-1)){
                max = len;
                len = 1;
            }
        }

        System.out.println(max);

        /*int max = 1;
        int muk = 1;
        for (int i = 0; i < list.size() - 1; i++) {

            while (list.get(i) == list.get(i + 1)) {
                max++;
                i++;
                if (i + 1 == list.size()) {
                    if (max > muk) {
                        System.out.println(max);
                        return;
                    } else {
                        System.out.println(muk);
                        return;
                    }
                }
            }
            if (max > muk) {
                muk = max;
                max = 1;
            }
        }
        System.out.println(muk);*/

    }
}