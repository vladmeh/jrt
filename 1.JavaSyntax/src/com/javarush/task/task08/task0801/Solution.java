package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> plantsHashSet = new HashSet<>();
        plantsHashSet.add("арбуз");
        plantsHashSet.add("банан");
        plantsHashSet.add("вишня");
        plantsHashSet.add("груша");
        plantsHashSet.add("дыня");
        plantsHashSet.add("ежевика");
        plantsHashSet.add("жень-шень");
        plantsHashSet.add("земляника");
        plantsHashSet.add("ирис");
        plantsHashSet.add("картофель");


        for (String s: plantsHashSet)
            System.out.println(s);

    }
}
