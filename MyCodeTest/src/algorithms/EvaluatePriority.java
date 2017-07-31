package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * @autor mvl on 28.07.2017.
 */
public class EvaluatePriority {


    public static void main(String[] args) {
        String string = "-5+1.5*4^3";
        evaluatePriority(string);
    }

    private static void evaluatePriority(String expression) {
        if (expression.charAt(0) == '-')
            expression = "0" + expression;

        List<Double> numbers =  new LinkedList<>();
        String[] nums = expression.split("[-+*/^]");
        for (String num: nums)
            numbers.add(Double.parseDouble(num));

        List<Character> operators = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '^'))
                operators.add(ch);
        }

        System.out.println(calc(numbers, operators));
    }

    private static double calc(List<Double> numbers, List<Character> operators){
        //Определяем индекс приритетного оператора
        while (operators.size() > 0) {
            double result = 0;
            int indexPriority = getPriorityOperator(operators);

            //зная индекс приритетного оператора получаем числа
            //удаляя их их последовательно из списка
            Double firstNumber = numbers.remove(indexPriority);
            Double secondNumber = numbers.remove(indexPriority);

            //получаем сам опрератор удаляя его из списка
            char operator = operators.remove(indexPriority);

            //делаем вычисления
            switch (operator) {
                case '^':
                    result = Math.pow(firstNumber, secondNumber);
                    break;
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
            }

            //добавляем результат на то место где делали вычисления
            numbers.add(indexPriority, result);

            calc(numbers, operators);
        }

        //т.к. чисел у нас всегда больше чем операторов на единицу
        //в итоге у нас должен остаться один результат
        return numbers.get(0);
    }

    private static int getPriorityOperator(List<Character> list){
        int index = 0;
        int priority = priority(list.get(index));
        for (Character ch: list){
            if (priority(ch) > priority){
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
