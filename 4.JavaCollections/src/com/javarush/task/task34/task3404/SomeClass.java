package com.javarush.task.task34.task3404;


import java.util.*;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass solution = new SomeClass();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //убираем пробелы, переводим в нижний регистр
        String string = expression.replace(" ", "").toLowerCase();

        List<String> out = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        StringBuilder st = new StringBuilder();

        //разбираем строку на слова
        StringTokenizer tokenizer = new StringTokenizer(expression, delimiters(), true);

        String prev = "";
        String curr = "";
        String next = "";

        while (tokenizer.hasMoreTokens()) {

            curr = tokenizer.nextToken();

            //boolean digit = isDigits(curr);

            //проверяем на корректность выражения
            if (!tokenizer.hasMoreTokens() && isOperator(curr)){
                throw new ArithmeticException("Некорректное выражение");
            }

            if (isFunction(curr)) out.add(curr);
            else if (isDelimiter(curr)) {
                if (curr.equals("(")){
                    while (!out.isEmpty()) st.append(out.remove(0));
                    st.append(curr);
                }
                //закрывающая скобка
                // это значит, что в списке осталось выражение без скобок
                // выражение может быть только простым т.е. с простыми операторами, без функций
                // надо выслить приритетный оператор и выслить по нему значение, которе потом вернуть
                // в строку.
                else if (curr.equals(")")){
                    int indexPriorityOperator = getIndexPriority(out);
                    double a = Double.parseDouble(out.remove(indexPriorityOperator-1));
                    String op = out.remove(indexPriorityOperator-1);
                    double b = Double.parseDouble(out.remove(indexPriorityOperator-1));
                    String result = calc(a, b, op);
                    System.out.println(result);
                    out.add(result);
                }
                else out.add(curr);
            }
            else if (isDigits(curr)){
                if (!isOperator(prev)){
                    while (!out.isEmpty()) st.append(out.remove(0));
                }
                out.add(curr);
            }
            else out.add(curr);
            prev = curr;

            System.out.println(st);
        }
    }


    public SomeClass() {
        //don't delete
    }

    private static String operators() {
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
        for (String string: list){
            if (priority(string) > priority){
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

    private static String calc(Double a, Double b, String operator){
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
