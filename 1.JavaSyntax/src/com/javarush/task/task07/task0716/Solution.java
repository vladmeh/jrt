package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        ArrayList<String> list_fix = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int r = s.indexOf("р");
            int l = s.indexOf("л");

            if(l == -1 && r == -1)
                list_fix.add(s);

            if (l > -1 && r > -1)
                list_fix.add(s);

            if (l > -1 && r == -1){
                list_fix.add(s);
                list_fix.add(s);
            }

        }
        return list_fix;
    }
}