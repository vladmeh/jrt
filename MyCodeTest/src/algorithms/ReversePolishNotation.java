package algorithms;

import java.util.*;

/**
 * @autor mvl on 06.09.2017.
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String expression = "sin(2*(-5+1.5*4)+28)";
        System.out.println(reversePolishNotation(expression));
        Double result = calc(reversePolishNotation(expression));
        System.out.println(String.valueOf(result));
    }

    private static Double calc(String postfixExp){
        List<String> postfix = new ArrayList<>();
        Deque<Double> stack = new ArrayDeque<>();

        StringTokenizer tokenizer = new StringTokenizer(postfixExp, " ");
        while (tokenizer.hasMoreTokens()) {
            postfix.add(tokenizer.nextToken());
        }

        for (String x: postfix){
            switch (x) {
                case "sin":
                    stack.push(Math.sin(Math.toRadians(stack.pop())));
                    break;
                case "cos":
                    stack.push(Math.cos(Math.toRadians(stack.pop())));
                    break;
                case "tan":
                    stack.push(Math.tan(Math.toRadians(stack.pop())));
                    break;
                case "^": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(Math.pow(a, b));
                    break;
                }
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                case "u-":
                    stack.push(-stack.pop());
                    break;
                default:
                    stack.push(Double.valueOf(x));
                    break;
            }
        }
        return stack.pop();
    }

    private static String reversePolishNotation(String expression){
        //убираем пробелы, переводим в нижний регистр
        expression = expression.replace(" ", "").toLowerCase();

        String result = "";

        List<String> out = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        //разбираем строку на слова
        StringTokenizer tokenizer = new StringTokenizer(expression, delimiters(), true);
        String prev = "";
        String curr = "";

        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(curr)){
                return "Некорректное выражение.";
            }

            //если функция помещаем в начало очереди
            if (isFunction(curr)) stack.push(curr);
            //если скобки или операторы
            else if (isDelimiter(curr)) {
                //если открывающая скобка - помещаем ее в начало очереди
                if (curr.equals("(")) stack.push(curr);
                //если закрывающая скобка
                else if (curr.equals(")")) {
                    //пока в начале очереди не будет открывающей скобки
                    while (!stack.peek().equals("(")) {
                        //добавляем из начала стека элементы в выходной список
                        out.add(stack.pop());
                        //если стек пустой возвращаем ошибку
                        if (stack.isEmpty()) {
                            return "Скобки не согласованы.";
                        }
                    }
                    //удаляем "(" из стека
                    stack.pop();
                    //если стек не пустой и в начале очереди функция
                    if (!stack.isEmpty() && isFunction(stack.peek())) {
                        //добавляем ее в выходной список
                        out.add(stack.pop());
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
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))){
                            //убираем элемент из очереди и добавляем его в выходной список
                            out.add(stack.pop());
                        }
                    }
                    //добавляем оператор в начало очереди
                    stack.push(curr);
                }
            }

            else {
                out.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) out.add(stack.pop());
            else {
                System.out.println("Скобки не согласованы.");
                return result;
            }
        }

        for (String string: out)
            result += string + " ";

        return result;
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
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        if (token.equals("^")) return 4;
        return 5;
    }
}
