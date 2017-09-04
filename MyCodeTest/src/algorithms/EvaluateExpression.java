package algorithms;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @autor mvl on 28.07.2017.
 */
public class EvaluateExpression {

    private static int priority;

    public static void main(String[] args) throws Exception {
        System.out.println(evaluateExpression("20/(7-3*2)"));
        System.out.println("check: " + String.valueOf(20d/(7-3*2)));
    }


    private static double evaluateExpression(String expression) throws Exception {
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') count++;
            else if (expression.charAt(i) == ')') {
                count--;
                if (count < 0) throw new Exception("Unexpected ) at position " + i + " in " + expression);
            }
            else if (count == 0) {
                char ch = expression.charAt(i);
                if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')) {
                    String operand1 = expression.substring(0, i);
                    String operand2 = expression.substring(i + 1);

                    double value1 = evaluateExpression(operand1);
                    double value2 = evaluateExpression(operand2);

                    double result;

                    switch (ch) {
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
                        default:
                            throw new UnknownError("Unknown operator " + ch);
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
