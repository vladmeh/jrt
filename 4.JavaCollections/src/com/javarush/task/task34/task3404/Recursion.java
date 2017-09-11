package com.javarush.task.task34.task3404;

import java.util.*;

/**
 * @autor mvl on 11.09.2017.
 */
public class Recursion {
    public static void main(String[] args) {
        Recursion solution = new Recursion();
        solution.recursion("sin(2*(1.5*4-5)+28)", 0); //sin(2*(-5+1.5*4)+28)
    }

    public void recursion(final String expression, int countOpetation){
        String exp = expression.replace(" ", "").toLowerCase();
        LinkedList<String> someInts = new LinkedList<>();
        LinkedList<String> someOpers = new LinkedList<>();

        StringTokenizer tokenizer = new StringTokenizer(exp, delimiters(), true);
        String token = "";
        while (tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();

            // Если функция
            if (isFunction(token)) someOpers.add(token);
            else if (isDelimiter(token)){
                // Если натыкаемся на открывающуюся скобку
                if (token.equals("(")) someOpers.add(token);

                else if (token.equals(")")){
                    while (!someOpers.getLast().equals("(")){
                        calc(someInts, someOpers.removeLast());
                    }
                    someOpers.removeLast();
                    System.out.println(someInts.toString());
                }

                else if (isOperator(token)){
                    while (!someOpers.isEmpty() && priority(someOpers.getLast()) >= priority(token)) {
                        calc(someInts, someOpers.removeLast());
                    }

                    someOpers.add(token);
                }
            }
            else {
                someInts.add(token);
            }
        }

        while (!someOpers.isEmpty()) {
            calc(someInts, someOpers.removeLast());
        }

        System.out.println(someInts.get(0));

    }

    private static String operators(){
        return "+-*/^";
    }

    private static String delimiters(){
        return "()" + operators();
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators().length(); i++) {
            if (token.charAt(0) == operators().charAt(i)) return true;
        }
        return false;
    }

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters().length(); i++) {
            if (token.charAt(0) == delimiters().charAt(i)) return true;
        }
        return false;
    }

    private static boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan");
    }

    private static int priority(String token) {
        if (token.equals("(")) return 0;
        if (token.equals("+") || token.equals("-")) return 1;
        if (token.equals("*") || token.equals("/")) return 2;
        if (token.equals("^")) return 3;
        return -1;
    }

    private static void calc(LinkedList<String> st, String oper) {

        // Инициализируем и объявляем две переменные
        // Первая берет последнее значение из переданного
        // связанного листа в параметре, запоминает и удаляет
        // его из списка
        double someOne = Double.parseDouble(st.removeLast());

        // Тоже самое делаем со второй переменной
        double someTwo = 0d;
        if (!st.isEmpty()) {
            someTwo = Double.parseDouble(st.removeLast());
        }

        // Пишем switch (можно if, но он длиннее по коду),
        // который учит переданный символ во 2 параметре
        // считать относительно своему предназначению
        switch(oper) {
            case "sin":
                st.add(String.valueOf(Math.sin(Math.toRadians(someOne))));
                break;
            case "cos":
                st.add(String.valueOf(Math.cos(Math.toRadians(someOne))));
                break;
            case "tan":
                st.add(String.valueOf(Math.tan(Math.toRadians(someOne))));
                break;
            case "+":
                st.add(String.valueOf(someTwo + someOne));
                break;
            case "-":
                st.add(String.valueOf(someTwo - someOne));
                break;
            case "*":
                st.add(String.valueOf(someTwo * someOne));
                break;
            case "/":
                st.add(String.valueOf(someTwo / someOne));
                break;
            case "^":
                st.add(String.valueOf((int)Math. pow(someTwo, someOne)));
                break;
            default:
                System.out.println("Oops");
        }
    }
}
