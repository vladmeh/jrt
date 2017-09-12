package com.javarush.task.task34.task3404;


import java.util.*;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass solution = new SomeClass();
        solution.recursion("sin(2*(8-4)+28)", 0); //sin(2*(-5+1.5*4)+28)
        //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        String exp = expression.replace(" ", "").toLowerCase();

        //Стек операторов
        Deque<String> opers = new LinkedList<>();
        //Стек чисел
        Deque<String> ints = new LinkedList<>();
        //Результирующая строка, которую мы должны использовать в рекурсии
        StringBuilder out = new StringBuilder();
        LinkedList<String> strings = new LinkedList<>();

        boolean flag = true;


        //Разбираем строку
        StringTokenizer tokenizer = new StringTokenizer(exp, delimiters(), true);
        //текущий токен
        String token = "";

        //Прохдим циклом по нашей строке
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            String tokenOut = token;
            if (flag) {
                //если натыкаемся на функцию, пишем ее в стек операторов
                if (isFunction(token)) opers.push(token);
                    //разделители
                else if (isDelimiter(token)) {
                    //если это открывающаяся скобка пишем ее в стек операторов (символов)
                    if (token.equals("(")) opers.push(token);
                        //если это закрывающаяся скобка
                    else if (token.equals(")")) {
                        while (!opers.peek().equals("(")) {
                            String b = ints.pop(), a = ints.pop();
                            String oper = opers.pop();
                            tokenOut = calc(Double.parseDouble(a), Double.parseDouble(b), oper);

                            System.out.println(a + oper + b + "=" + tokenOut);

                            flag = false;
                        }
                        opers.pop();
                    }
                    // если это оператор
                    // пока стек операторов не пустой и приоритет верхнего оператора
                    // в стеке больше или равен приоритету текущего
                    else {
                        if (!opers.isEmpty() && priority(opers.peek()) >= priority(token)) {
                            String b = ints.pop(), a = ints.pop();
                            String oper = opers.pop();
                            tokenOut = calc(Double.parseDouble(a), Double.parseDouble(b), oper);

                            System.out.println(a + oper + b + "=" + tokenOut);

                            flag = false;
                        }

                        opers.push(token);
                    }
                }
                //если это число, пишем его в стек чисел
                else {
                    ints.push(token);
                }
            }

            strings.add(tokenOut);
            System.out.println(ints.toString());
            System.out.println(opers.toString());
            System.out.println();
            System.out.println(strings.toString());
        }

        for (String string : strings)
            out.append(string);

        System.out.println(out);
    }


    public SomeClass() {
        //don't delete
    }

    private static String operators() {
        return "+-*/^";
    }

    private static String delimiters() {
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
        switch (token) {
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }

    private static int getIndexPriority(List<String> list) {
        int index = 0;
        int priority = priority(list.get(index));
        for (String string : list) {
            if (priority(string) > priority) {
                priority = priority(string);
                index = list.indexOf(string);
            }
        }
        return index;
    }

    private static boolean isDigits(String token) {
        try {
            final double v = Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ignored) {
        }
        return false;
    }

    private static String calc(double a, double b, String operator) {

        Double result = 0d;

        switch (operator) {
            case "^":
                result = Math.pow(a, b);
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

        return String.valueOf(result);
    }
}
