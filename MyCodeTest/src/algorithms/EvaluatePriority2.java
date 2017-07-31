package algorithms;

import java.util.*;

/**
 * @autor mvl on 31.07.2017.
 */
public class EvaluatePriority2 {
    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/', '^');

    public static void main(String[] args) {
        String string = "-5*1.5+3+4^3";
        evaluatePriority(string);
    }

    private static void evaluatePriority(String expression){
        if (expression.charAt(0) == '-')
            expression = "0" + expression;

        System.out.println(expression);

        List<Character> operators = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperator(ch)) operators.add(ch);
        }

        char priorityOperator = getPriorityOperator(expression);
        System.out.println(priorityOperator);

        String beginString = "";
        String calculate = "";
        String endString = "";

        //если оператор находится в конце списка
        if (operators.indexOf(priorityOperator) == operators.size()-1){
            //определяем предыдущий оператор
            char prevOperator = operators.get(operators.indexOf(priorityOperator)-1);
            beginString = expression.substring(0, expression.indexOf(prevOperator)+1);
            calculate = expression.substring(expression.indexOf(prevOperator)+1);
        }
        else if (operators.indexOf(priorityOperator) == 0){
            char nextOperator = operators.get(operators.indexOf(priorityOperator)+1);
            calculate = expression.substring(0, expression.indexOf(nextOperator));
            endString = expression.substring(expression.indexOf(nextOperator));
        }

        else if (operators.indexOf(priorityOperator) != operators.size()-1
                && operators.indexOf(priorityOperator) != 0){
            char prevOperator = operators.get(operators.indexOf(priorityOperator)-1);
            char nextOperator = operators.get(operators.indexOf(priorityOperator)+1);

            beginString = expression.substring(0, expression.indexOf(prevOperator)+1);
            calculate = expression.substring(expression.indexOf(prevOperator)+1, expression.indexOf(nextOperator));
            endString = expression.substring(expression.indexOf(nextOperator));

        }

        String string = beginString + calc(calculate) + endString;
        System.out.println(string);

    }

    private static boolean isOperator(char ch) {
        return OPERATORS.contains(ch);
    }

    private static char getPriorityOperator(String expression){
        char ch = '+';
        int priority = priority(ch);
        for (int i = 0; i < expression.length(); i++) {
            if (priority(expression.charAt(i)) > priority){
                priority = priority(expression.charAt(i));
                ch = expression.charAt(i);
            }
        }
        return ch;
    }

    private static double calc(String expression){

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperator(ch)){
                String operand1 = expression.substring(0, i);
                String operand2 = expression.substring(i + 1);

                double value1 = Double.parseDouble(operand1);
                double value2 = Double.parseDouble(operand2);

                switch (ch) {
                    case '^':
                        return Math.pow(value1, value2);
                    case '+':
                        return value1 + value2;
                    case '-':
                        return value1 - value2;
                    case '*':
                        return value1 * value2;
                    case '/':
                        return value1 / value2;
                    default:
                        throw new UnknownError("Unknown operator " + ch);
                }
            }
        }

        return 0;
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
