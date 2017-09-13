package com.javarush.task.task34.task3404;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass2 {
    public static void main(String[] args) {
        SomeClass2 solution = new SomeClass2();
        solution.recursion("2*(3+5)/4", 0); //sin(2*(-5+1.5*4)+28)
        //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        String exp = expression.replace(" ", "").toLowerCase();

        Deque<String> opers = new LinkedList<>();
        Deque<String> numbers = new LinkedList<>();

        StringTokenizer tokenizer = new StringTokenizer(exp, delimiters(), true);
        String curr = "";


        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                System.out.println("Некорректное выражение.");
                break;
            }


            //функция
            if (isFunction(curr)) opers.push(curr);
                //открывающая скобка
            else if (curr.equals("(")) {
                opers.push(curr);
            }
            // закрывающая скобка
            else if (curr.equals(")")) {
                if (!opers.peek().equals("(")) {
                    String b = numbers.pop(), a = numbers.pop();

                    String pattern = String.format("\\(%s\\%s%s\\)", a, opers.peek(), b);
                    //System.out.println(pattern);

                    String result = calc(Double.parseDouble(a), Double.parseDouble(b), opers.pop());
                    //System.out.println(result);

                    exp = exp.replaceAll(pattern, result);
                    //System.out.println(exp);
                    recursion(exp, ++countOperation);
                }
                opers.pop();

                //если стек не пустой и в начале очереди функция
                if (!opers.isEmpty() && isFunction(opers.peek())) {

                    String func = opers.pop();
                    String val = numbers.pop();

                    String pattern = String.format("%s\\(%s\\)", func, val);
                    //System.out.println(pattern);

                    String result = calc(Double.parseDouble(val), func);
                    //System.out.println(result);

                    exp = exp.replaceAll(pattern, result);
                    //System.out.println(exp);
                    recursion(exp, ++countOperation);
                }
            }
            //операторы
            else if (isOperator(curr)) {
                if (!opers.isEmpty() && priority(opers.peek()) >= priority(curr)) {
                    String b = numbers.pop(), a = numbers.pop();
                    String oper = opers.pop();

                    String pattern = String.format("%s\\%s%s", a, oper, b);
                    //System.out.println(pattern);

                    String result = calc(Double.parseDouble(a), Double.parseDouble(b), oper);
                    //System.out.println(result);

                    exp = exp.replaceAll(pattern, result);
                    //System.out.println(exp);
                    recursion(exp, ++countOperation);
                }
                opers.push(curr);
            }
            //числа
            else {
                numbers.push(curr);
            }
        }

        if (!opers.isEmpty()){
            System.out.println(opers.toString());
            System.out.println(numbers.toString());
        }

        //System.out.println(exp + " " + countOperation);
    }


    public SomeClass2() {
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

    private static String calc (double val, String func){
        Double result = 0d;

        switch (func) {
            case "sin":
                result = Math.sin(Math.toRadians(val));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(val));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(val));
                break;
        }

        return String.valueOf(result);
    }
}
