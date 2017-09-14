package com.javarush.task.task34.task3404;


import java.text.DecimalFormat;
import java.util.*;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass2 {
    public static void main(String[] args) {
        SomeClass2 solution = new SomeClass2();
        solution.recursion("2+28", 0); //sin(2*(-5+1.5*4)+28)
        //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        String exp = expression.replace(" ", "").toLowerCase();

        List<String> strings = new ArrayList<>();
        Deque<String> opers = new LinkedList<>();
        Deque<String> numbers = new LinkedList<>();

        StringTokenizer tokenizer = new StringTokenizer(exp, delimiters(), true);
        //String curr = "";
        String format = "";
        String result = "";


        while (tokenizer.hasMoreTokens()){
            strings.add(tokenizer.nextToken());
        }


        for (String curr: strings){
            /*curr = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                System.out.println("Некорректное выражение.");
                break;
            }*/

            /*//функция
            if (isFunction(curr)) opers.push(curr);
            //открывающая скобка
            else if (curr.equals("(")) opers.push(curr);
            // закрывающая скобка
            else if (curr.equals(")")) {
                if (!opers.peek().equals("(")) {
                    String b = numbers.pop(), a = numbers.peek(), oper = opers.pop();
                    if (!opers.peek().equals("("))
                        format = String.format("%s\\%s%s", a, oper, b);
                    else
                        format = String.format("\\(%s\\%s%s\\)", a, oper, b);
                    numbers.push(b);
                    result = calc(numbers, oper);
                    String st = exp.replaceAll(format, result);
                    recursion(st, ++countOperation);
                }
                opers.pop();
                //выходим из цикла
                break;
            }*/
            //операторы
            if (isOperator(curr)) {
                if (!opers.isEmpty() && priority(opers.peek()) >= priority(curr)) {
                    String b = numbers.pop(), a = numbers.peek(), oper = opers.peek();
                    format = String.format("%s\\%s%s", a, oper, b);
                    numbers.push(b);
                    /*result = calc(numbers, oper);
                    String st = exp.replaceAll(format, result);
                    recursion(st, ++countOperation);*/
                    break;
                }
                opers.push(curr);
            }
            //числа
            else {
                numbers.push(curr);
            }
        }


        if (!opers.isEmpty()){
            result = calc(numbers, opers.pop());
            exp = exp.replaceAll(format, result);
            if (!opers.isEmpty())
                recursion(exp,++countOperation);
        }


        System.out.println(exp);
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

    private static boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan");
    }


    private static int priority(String token) {
        if (token.equals("(")) {
            return 0;
        } else if (token.equals("+") || token.equals("-")) {
            return 1;
        } else if (token.equals("*") || token.equals("/")) {
            return 2;
        } else if (token.equals("^")) {
            return 3;
        }
        return -1;
    }


    private static String calc (Deque<String> numbers, String operator){
        Locale.setDefault(Locale.ENGLISH);
        Double result = 0d;

        switch (operator) {
            case "sin":
                result = Math.sin(Math.toRadians(Double.parseDouble(numbers.pop())));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(Double.parseDouble(numbers.pop())));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(Double.parseDouble(numbers.pop())));
                break;
            case "^": {
                Double b = Double.parseDouble(numbers.pop()), a = Double.parseDouble(numbers.pop());
                result = Math.pow(a, b);
                break;
            }
            case "+":
                result = Double.parseDouble(numbers.pop()) + Double.parseDouble(numbers.pop());
                break;
            case "-": {
                Double b = Double.parseDouble(numbers.pop()), a = Double.parseDouble(numbers.pop());
                result = a - b;
                break;
            }
            case "*":
                result = Double.parseDouble(numbers.pop()) * Double.parseDouble(numbers.pop());
                break;
            case "/": {
                Double b = Double.parseDouble(numbers.pop()), a = Double.parseDouble(numbers.pop());
                result = a / b;
                break;
            }
        }

        return new DecimalFormat("#.##").format(result);
    }
}
