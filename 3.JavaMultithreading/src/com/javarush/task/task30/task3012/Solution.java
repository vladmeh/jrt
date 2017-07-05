package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private final List<String> numbers = Arrays.asList("1", "3", "9", "27", "81", "243", "729", "2187");
    private List<String> listBalancedTernaryNumber = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        System.out.println(Arrays.toString(numbers.toArray()));
        recursiveTernary(number);

        StringBuilder s = new StringBuilder(number + " = ");
        for (int i = 0; i < listBalancedTernaryNumber.size(); i++) {
            if (!listBalancedTernaryNumber.get(i).equals("0")){
                s.append(" ").append(listBalancedTernaryNumber.get(i)).append(" ").append(numbers.get(i));
            }
        }

        System.out.println(Arrays.toString(listBalancedTernaryNumber.toArray()));
        System.out.println(s);
    }

    private void recursiveTernary(int number) {
        int numDiv = number/3;
        int modDiv = number%3;

        if (number > 0){
            switch (modDiv){
                case 0:
                    listBalancedTernaryNumber.add("0");
                    break;
                case 1:
                    listBalancedTernaryNumber.add("+");
                    break;
                case 2:
                    listBalancedTernaryNumber.add("-");
                    numDiv++;
                    break;
            }
            recursiveTernary(numDiv);
        }
    }
}