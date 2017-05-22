package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов

В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе getLine должен быть использован StringBuilder
3. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы параметры(слова).
4. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
5. Вывод на экран должен соответствовать условию задачи.
*/
public class MySolution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String[] words = reader.readLine().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length > 0){
            Arrays.sort(words);
            sb.append(words[0]);
            for (int i = 1; i < words.length; i++) {
                for (int j = 1; j < words.length; j++) {
                    if (words[j].toLowerCase().charAt(0) == sb.charAt(sb.length() - 1)){
                        sb.append(" " + words[j]);
                    }
                }
            }
        }
        return sb;
    }
}
