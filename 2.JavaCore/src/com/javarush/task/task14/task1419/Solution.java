package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        //1. ArithmeticException
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //2. ArrayStoreException
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //3. ClassCastException
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //4. ClassNotFoundException
        try {
            Class t = Class.forName("java.lang.My");
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //5. IllegalFormatConversionException
        try {
            int x = 10;
            String name = "Васе";
            String a = "лет";
            System.out.printf("%s %d %s", x, a, name);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //6. ArrayIndexOutOfBoundsException
        try {
            int c[] = { 1 };
            c[42] = 99;

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //7. NumberFormatException
        try {
            String s = "3f";
            int n = Integer.parseInt(s);
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //8. StringIndexOutOfBoundsException
        try {
            String str = "Java Code Geeks!";
            System.out.println("Length: " + str.length());
            char ch = str.charAt(50);

        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //9. FileNotFoundException
        try {
            FileInputStream file = new FileInputStream("test.txt");

            Scanner in = new Scanner(file, "UTF-8");

            while (in.hasNext())
                System.out.println(in.nextLine());

            file.close();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

        //10. NullPointerException
        try {
            Object obj = null;
            obj.hashCode();
        }
        catch (Exception e) {
            exceptions.add(e);
        }

    }
}
