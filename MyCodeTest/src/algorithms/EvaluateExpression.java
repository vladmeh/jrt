package algorithms;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @autor mvl on 28.07.2017.
 */
public class EvaluateExpression {

    public static void main(String[] args) throws Exception {
        System.out.println(evaluateExpression("sin(28+(-5+1.5*4)*2)"));
        System.out.println("check: " + String.valueOf((float)Math.sin(Math.toRadians(28+(-5+1.5*4)*2))));
    }


    private static double evaluateExpression(String expression) throws Exception {
        if (expression.charAt(0) == '-')
            return evaluateExpression("0"+expression);

        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') count++;
            else if (expression.charAt(i) == ')') {
                count--;
                if (count < 0) throw new ArithmeticException("Unexpected ) at position " + i + " in " + expression);
            }
            else if (count == 0) {
                char ch = expression.charAt(i);
                if ((ch == '^') || (ch == '*') || (ch == '/') || (ch == '-') || (ch == '+')) {


                    String operand1 = expression.substring(0, i);
                    String operand2 = expression.substring(i + 1);

                    double value1 = evaluateExpression(operand1);
                    double value2 = evaluateExpression(operand2);

                    double result;

                    switch (ch) {
                        case '^':
                            result = Math.pow(value1, value2);
                            break;
                        case '*':
                            result = value1 * value2;
                            break;
                        case '/':
                            result = value1 / value2;
                            break;
                        case '+':
                            result = value1 + value2;
                            break;
                        case '-':
                            result = value1 - value2;
                            break;
                        default:
                            throw new ArithmeticException("Unknown operator " + ch);
                    }
                    System.out.println(expression + " = " + result);

                    return result;
                }
            }
        }

        if (expression.charAt(0) == '('
                && matchingParenIndex(expression, 0) == expression.length() - 1) {
            return evaluateExpression(expression.substring(1, expression.length() - 1));
        }

        switch (expression.charAt(0)) {
            case 's':
                return (float)Math.sin(Math.toRadians(evaluateExpression(expression.substring(4, expression.length()-1))));
            case 'c':
                return (float)Math.cos(Math.toRadians(evaluateExpression(expression.substring(4, expression.length()-1))));
            case 't':
                return (float)Math.tan(Math.toRadians(evaluateExpression(expression.substring(4, expression.length()-1))));
        }

        return Double.parseDouble(expression);
    }

    private static int matchingParenIndex(String expression, int openParenIndex) throws Exception {
        int count = 0;
        for (int i = openParenIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') count++;
            else if (expression.charAt(i) == ')') count--;
            if (count == 0) return i;
            if (count < 0) return -1;
        }
        return -1;
    }
}
