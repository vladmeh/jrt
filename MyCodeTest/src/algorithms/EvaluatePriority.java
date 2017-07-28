package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor mvl on 28.07.2017.
 */
public class EvaluatePriority {


    public static void main(String[] args) {
        String string = "555+20/5.5*8-255";
        evaluatePriority(string);
    }

    private static void evaluatePriority(String expression) {
        List<String> numbers = Arrays.asList(expression.split("[-+*/]"));
        List<Character> operators = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/'))
                operators.add(ch);
        }

        if (operators.contains('*')){

        }

    }

    private static int priority(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }
}
