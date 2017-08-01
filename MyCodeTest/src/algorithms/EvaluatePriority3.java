package algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * @autor mvl on 01.08.2017.
 */
public class EvaluatePriority3 {
    private static final List<Character> OPERATORS = Arrays.asList('+', '-', '*', '/', '^');

    public static void main(String[] args) {
        String string = "5*1.5+3+4^3"; //-5*1.5+3+4^3
        System.out.println(evaluatePriority(string));
    }

    private static double evaluatePriority(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            //сначала делим строку по наименьшему приоритету
            if ((ch == '+') || (ch == '-')) {
                String operand1 = expression.substring(0, i);
                String operand2 = expression.substring(i + 1);

                double value1 = evaluatePriority(operand1);
                double value2 = evaluatePriority(operand2);

                double result = 0;

                switch (ch) {
                    case '+':
                        result = value1 + value2;
                        break;
                    case '-':
                        result = value1 - value2;
                        break;
                }
                System.out.println(expression + " = " + result);
                return result;
            }

            if ((ch == '*') && !isMinOperator(expression, ch)) {
                String operand1 = expression.substring(0, i);
                String operand2 = expression.substring(i + 1);

                double value1 = evaluatePriority(operand1);
                double value2 = evaluatePriority(operand2);

                double result = value1 * value2;

                System.out.println(expression + " = " + result);

                return result;
            }

            if ((ch == '/') && !isMinOperator(expression, ch)) {
                String operand1 = expression.substring(0, i);
                String operand2 = expression.substring(i + 1);

                double value1 = evaluatePriority(operand1);
                double value2 = evaluatePriority(operand2);

                double result = value1 / value2;

                System.out.println(expression + " = " + result);

                return result;
            }

            if ((ch == '^') && !isMinOperator(expression, ch)) {
                String operand1 = expression.substring(0, i);
                String operand2 = expression.substring(i + 1);

                double value1 = evaluatePriority(operand1);
                double value2 = evaluatePriority(operand2);

                double result = Math.pow(value1, value2);

                System.out.println(expression + " = " + result);

                return result;
            }
        }

        return Double.parseDouble(expression);
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.contains(ch);
    }

    private static int getCountOperators(String expression) {
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (isOperator(expression.charAt(i))) count++;
        }
        return count;
    }

    private static boolean isMinOperator(String exp, char operator) {
        for (int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            if (isOperator(ch) && getPriority(ch) < getPriority(operator)){
                return true;
            }
        }
        return false;
    }

    private static int getPriority(char operator) {
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
