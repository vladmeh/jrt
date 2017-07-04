package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        boolean check = false;
        for(int i = 2; i < 37; i++){
            try{
                new BigDecimal(new BigInteger(args[0],i));
                System.out.println(i);
                check = true;
                break;
            }catch (Exception ignored){
            }
        }
        if(!check) System.out.println("incorrect");
    }
}