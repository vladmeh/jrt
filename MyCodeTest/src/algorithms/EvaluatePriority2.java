package algorithms;

import java.util.*;

/**
 * @autor mvl on 31.07.2017.
 */
public class EvaluatePriority2 {
    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/', '^');

    public static void main(String[] args) {
        String string = "-5*1.5+3+4^3"; //-5*1.5+3+4^3
        evaluatePriority(string);
    }

    private static void evaluatePriority(String expression) {
        if (expression.charAt(0) == '-')
            expression = "0" + expression;

        List<Double> numbers = new LinkedList<>();
        String[] nums = expression.split("[-+*/^]");
        for (String num : nums)
            numbers.add(Double.parseDouble(num));

        List<Character> operators = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperator(ch)) operators.add(ch);
        }

        if (numbers.get(0) == 0 && operators.get(0) == '-') {
            numbers.remove(0);
            numbers.add(0, 0 - numbers.remove(0));
            operators.remove(0);
        }

        double result = 0;
        int indexPriority = getPriorityOperator(operators);

        Double value1 = numbers.remove(indexPriority);
        Double value2 = numbers.remove(indexPriority);

        char operator = operators.remove(indexPriority);

        //делаем вычисления
        switch (operator) {
            case '^':
                result = Math.pow(value1, value2);
                break;
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                result = value1 / value2;
                break;
        }
        numbers.add(indexPriority, result);

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < operators.size(); i++) {
            char o = operators.get(i);
            double n1 = numbers.get(i);
            string.append(String.valueOf(n1)).append(String.valueOf(o));
            if (i == operators.size() - 1)
                string.append(String.valueOf(numbers.get(i + 1)));
        }

        if (operators.size() > 0) {
            evaluatePriority(string.toString());
        } else
            System.out.println(result);
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.contains(ch);
    }


    private static int getPriorityOperator(List<Character> list) {
        int index = 0;
        int priority = priority(list.get(index));
        for (Character ch : list) {
            if (priority(ch) > priority) {
                priority = priority(ch);
                index = list.indexOf(ch);
            }
        }
        return index;
    }

    private static int priority(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '/':
                return 2;
            case '*':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }
}
