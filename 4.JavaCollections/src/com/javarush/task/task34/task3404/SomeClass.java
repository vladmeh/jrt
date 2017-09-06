package com.javarush.task.task34.task3404;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor mvl on 01.08.2017.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass solution = new SomeClass();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        String exp = expression; //передаваемое выражение
        String expInBkt = expression; //выражение внутри скобок
        String expBkt = expression; //выражение со скобками
        int countOper = countOperation; //счетчик операций

        //Подсчет всех операций
        if (countOper == 0){
            countOper += (exp.split("\\^").length - 1)+(exp.split("/").length-1)+(exp.split("\\*").length-1)
                    +(exp.split("\\+").length-1)+(exp.split("-").length-1)+(exp.split("cos").length-1)+(exp.split("sin").length-1)+(exp.split("tan").length-1);
        }

        //находим индекс последней открытой скобки
        int lastIndexOpenBkt = exp.lastIndexOf('(');
        //если такая есть
        if (lastIndexOpenBkt >= 0) {
            int firstIndexCloseBkt = exp.indexOf(')');
            //если такая есть
            if (firstIndexCloseBkt > 0){
                //вырезаем строку внутри скобок
                expInBkt = exp.substring(lastIndexOpenBkt+1, firstIndexCloseBkt);
                //вырезаем строку со скобками
                expBkt = exp.substring(lastIndexOpenBkt, firstIndexCloseBkt+1);
            }
            else throw new ArithmeticException("Нет закрывающей скобки у выражения: \"" + exp.substring(lastIndexOpenBkt) + "\"");
        }

        //Создаем список чисел
        List<Double> numbers =  new LinkedList<>();

        //Если имеется унарный оператор вначале выражения подставляем 0
        if (expInBkt.charAt(0) == '-')
            expInBkt = "0" + expInBkt;

        String[] nums = expInBkt.split("[-+*/^]");
        for (String num: nums)
            numbers.add(Double.parseDouble(num));

        //Создаем список операторов
        List<Character> operators = new LinkedList<>();
        for (int i = 0; i < expInBkt.length(); i++) {
            char ch = expInBkt.charAt(i);
            if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '^'))
                operators.add(ch);
        }

        //index оператора который будет выполняться
        int indexOperator = 0;

        //находим оператор в списке по приоритету и определяем его индекс
        while (operators.size() > 0){
            if (operators.contains('^')){
                indexOperator = operators.indexOf('^');
                break;
            }

            if (operators.contains('*')){
                indexOperator = operators.indexOf('*');
                break;
            }

            if (operators.contains('/')){
                indexOperator = operators.indexOf('/');
                break;
            }

            if (operators.contains('-')){
                indexOperator = operators.indexOf('-');
                break;
            }

            if (operators.contains('+')){
                indexOperator = operators.indexOf('+');
                break;
            }
        }

        //зная индеск оператора мы можем определить числа
        // над которыми будем определять действия найденным оператором
        Double firstNumber = numbers.remove(indexOperator);
        Double secondNumber = numbers.remove(indexOperator);
        char operator = operators.get(indexOperator);

        //делаем вычисления
        double result = 0;

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

        System.out.println("Искомая строка: " + exp);
        System.out.println("Первое что будем вычислять: " + expBkt);
        System.out.println("делаем вычисления: " + String.valueOf(firstNumber) + String.valueOf(operator) + String.valueOf(secondNumber) + " = " + String.valueOf(result));
    }

    private int countOperation(String expression){
        return (expression.split("\\^").length-1) + (expression.split("/").length-1) + (expression.split("\\*").length-1) + (expression.split("\\+").length-1) + (expression.split("-").length-1);
    }

    public SomeClass() {
        //don't delete
    }
}
