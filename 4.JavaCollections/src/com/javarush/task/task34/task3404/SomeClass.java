package com.javarush.task.task34.task3404;


import java.text.DecimalFormat;
import java.util.*;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass solution = new SomeClass();
        solution.recursion("sin(45)", 0); //sin(2*(-5+1.5*4)+28)
        //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        Locale.setDefault(Locale.ENGLISH);

        if (countOperation > 0){
            System.out.println(expression + " " + countOperation);
        }
        else {
            //==================================================================
            //Первая часть Марлезонского балета
            //Переводим выражение в постфиксную запись (обратная польская запись)

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

                //если функция помещаем в начало очереди
                if (isFunction(curr)) stackPostfix.push(curr);
                    //если скобки или операторы
                else if (isDelimiter(curr)) {
                    //если открывающая скобка - помещаем ее в начало очереди
                    if (curr.equals("(")) stackPostfix.push(curr);
                        //если закрывающая скобка
                    else if (curr.equals(")")) {
                        //пока в начале очереди не будет открывающей скобки
                        while (!stackPostfix.peek().equals("(")) {
                            //добавляем из начала стека элементы в выходной список
                            out.add(stackPostfix.pop());
                            //если стек пустой возвращаем ошибку
                            if (stackPostfix.isEmpty()) {
                                System.out.println("Скобки не согласованы.");
                            }
                        }
                        //удаляем "(" из стека
                        stackPostfix.pop();
                        //если стек не пустой и в начале очереди функция
                        if (!stackPostfix.isEmpty() && isFunction(stackPostfix.peek())) {
                            //добавляем ее в выходной список
                            out.add(stackPostfix.pop());
                        }
                    }
                    //оставшиеся операторы
                    else {
                        //унарный минус
                        if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                            curr = "u-";
                        }
                        else {
                            //пока очередь не пуста и приритет текущего элемента меньше или равна приоритету элемента в начале очереди
                            while (!stackPostfix.isEmpty() && (priority(curr) <= priority(stackPostfix.peek()))){
                                //убираем элемент из очереди и добавляем его в выходной список
                                out.add(stackPostfix.pop());
                            }
                        }
                        //добавляем оператор в начало очереди
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
                }
            }

            //============================================================
            //Вторая часть марлезонского балета
            //делаем вычисления
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
        return 4;
    }
}
