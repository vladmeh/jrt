package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.*;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);

        if (countOperation > 0){
            System.out.println(expression + " " + countOperation);
        }
        else {
            List<String> out = new ArrayList<>();
            Deque<String> stackPostfix = new ArrayDeque<>();
            Deque<Double> stack = new ArrayDeque<>();

            StringTokenizer tokenizer = new StringTokenizer(expression.replace(" ", "").toLowerCase(), delimiters(), true);
            String prev = "";
            String curr = "";

            while (tokenizer.hasMoreTokens()) {
                curr = tokenizer.nextToken();

                if (!tokenizer.hasMoreTokens() && isOperator(curr)){
                    System.out.println("Некорректное выражение.");
                    break;
                }

                if (isFunction(curr)) stackPostfix.push(curr);
                else if (isDelimiter(curr)) {
                    if (curr.equals("(")) stackPostfix.push(curr);
                    else if (curr.equals(")")) {
                        while (!stackPostfix.peek().equals("(")) {
                            out.add(stackPostfix.pop());
                            if (stackPostfix.isEmpty()) {
                                System.out.println("Скобки не согласованы.");
                            }
                        }
                        stackPostfix.pop();
                        if (!stackPostfix.isEmpty() && isFunction(stackPostfix.peek())) {
                            out.add(stackPostfix.pop());
                        }
                    }
                    else {
                        if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                            curr = "u-";
                        }
                        else {
                            while (!stackPostfix.isEmpty() && (priority(curr) <= priority(stackPostfix.peek()))){
                                out.add(stackPostfix.pop());
                            }
                        }
                        stackPostfix.push(curr);
                    }
                }

                else {
                    out.add(curr);
                }
                prev = curr;
            }

            while (!stackPostfix.isEmpty()) {
                if (isOperator(stackPostfix.peek())) out.add(stackPostfix.pop());
                else {
                    System.out.println("Скобки не согласованы.");
                    break;
                }
            }
            for (String x: out){
                switch (x) {
                    case "sin":
                        stack.push(Math.sin(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "cos":
                        stack.push(Math.cos(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "tan":
                        stack.push(Math.tan(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "^": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(Math.pow(a, b));
                        countOperation++;
                        break;
                    }
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        countOperation++;
                        break;
                    case "-": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a - b);
                        countOperation++;
                        break;
                    }
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        countOperation++;
                        break;
                    case "/": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a / b);
                        countOperation++;
                        break;
                    }
                    case "u-":
                        stack.push(-stack.pop());
                        countOperation++;
                        break;
                    default:
                        stack.push(Double.valueOf(x));
                        break;
                }
            }

            recursion(new DecimalFormat("#.##").format(stack.pop()), countOperation);
        }
    }

    public Solution() {
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
        return 4;
    }
}
