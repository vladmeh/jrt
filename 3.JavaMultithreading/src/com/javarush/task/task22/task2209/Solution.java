package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
public class Solution {
    public static void main(String[] args) throws IOException {
        String[] words;
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream file = new FileInputStream(reader.readLine());
        ){
            Scanner in = new Scanner(file, "UTF-8");
            words = in.nextLine().split(" ");
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length > 0){
            //добавляем наши слова в список
            List<String> list = new ArrayList<>(Arrays.asList(words));

            while (true){
                Collections.shuffle(list);
                boolean isCorrect = true;
                //проверка правильной последовательности
                for(int i = 0; i < list.size()-1; i++){
                    if (list.get(i+1).toLowerCase().charAt(0) != list.get(i).toLowerCase().charAt(list.get(i).length()-1)){
                        isCorrect = false;
                        break;
                    }
                }

                if(isCorrect) break;
            }
            //создаем наш возвращаемый объект
            for (int i = 0; i < list.size(); i++) {
                String format = "%s";
                if (i != list.size()-1)
                    format = "%s ";

                sb.append(String.format(format, list.get(i)));
            }
        }
        return sb;
    }
}
