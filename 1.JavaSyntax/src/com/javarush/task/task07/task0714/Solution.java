package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк. Удали 3 — ий элемент списка, и выведи оставшиеся элементы в обратном порядке.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 5 строк с клавиатуры и добавь их в список.
3. Удали третий элемент массива.
4. Выведи элементы на экран.
5. Порядок вывода должен быть обратный.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            list.add(reader.readLine());

        list.remove(2);

        for (int i = list.size()-1; i >= 0; i--)
            System.out.println(list.get(i));
    }
}


