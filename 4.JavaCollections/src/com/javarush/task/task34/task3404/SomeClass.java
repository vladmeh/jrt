package com.javarush.task.task34.task3404;

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
        String s = expression;
        String s1 = expression;
        String fulls1=expression;
        int count = countOperation;

        //Подсчет всех операций
        if (count == 0){
            count += (s.split("^").length - 1)+(s.split("/").length-1)+(s.split("\\*").length-1)
                    +(s.split("\\+").length-1)+(s.split("-").length-1)+(s.split("cos").length-1)+(s.split("sin").length-1)+(s.split("tan").length-1);
        }

        //находим индекс последней открытой скобки
        int lastIndexOpenBkt = expression.lastIndexOf('(');
        //если такая есть
        if (lastIndexOpenBkt >= 0) {
            //обрезаем строку от найденой скобки
            String sp = expression.substring(lastIndexOpenBkt);
            //обрезаем строку до зарывающей скобки включителльно
            fulls1 = sp.substring(0, sp.indexOf(")")+1);
            //вырезаем строку внутри скобок
            s1 = sp.substring(1,sp.indexOf(")"));
        }

        System.out.println(s1);
    }

    public SomeClass() {
        //don't delete
    }
}
