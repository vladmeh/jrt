package com.javarush.task.task08.task0801;

/* 
HashSet из растений

Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.


Требования:
1. Объяви переменную коллекции HashSet с типом элементов String и сразу проинициализируй ee.
2. Программа не должна считывать строки с клавиатуры.
3. Программа должна добавлять в коллекцию 10 строк, согласно условию.
4. Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.

*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> plantsHashSet = new HashSet<>();
        plantsHashSet.add("арбуз");
        plantsHashSet.add("банан");
        plantsHashSet.add("вишня");
        plantsHashSet.add("груша");
        plantsHashSet.add("дыня");
        plantsHashSet.add("ежевика");
        plantsHashSet.add("жень-шень");
        plantsHashSet.add("земляника");
        plantsHashSet.add("ирис");
        plantsHashSet.add("картофель");


        for (String s: plantsHashSet)
            System.out.println(s);

    }
}
