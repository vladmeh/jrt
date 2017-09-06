package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @autor mvl on 06.09.2017.
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String expression = "-5+1.5*4^3";
        System.out.println(reversePolishnotation(expression));
    }

    private static String reversePolishnotation(String expression){
        String result = "";

        List<String> out = new ArrayList<>();
        Stack<Character> operators = new Stack<>();


        String number = "";

        for (int i = 0; i < expression.length(); i++) {
            //читаем символ
            char ch = expression.charAt(i);

            //если число
            if ((ch >= '0' && ch <= '9') || (ch == '.')){
                if (i < expression.length() - 1)
                {
                    number += ch;
                    continue;
                } else
                {
                    number += ch;
                }
            }

            //System.out.println(number);

            if (!number.equals(""))
            {
                out.add(number);
                number = "";
            }

            if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '^'))
                operators.add(ch);

        }

        for (String s: out)
            System.out.println(s);

        for (Character ch: operators)
            System.out.println(ch);

        return result;
    }
}
