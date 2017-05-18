package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Обращенные слова

В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder
3. Список result должен быть заполнен корректными парами согласно условию задачи.
4. В классе Solution должен содержаться вложенный класс Pair.

{testFiles/pair.txt}
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(new FileInputStream(reader.readLine()), "UTF-8")
        ){
            while (in.hasNext())
                words.add(in.next());
        }

        //Перебираем массив слов из файла
        for (int i = 0; i < words.size(); i++) {
            //каждое слово сравниваем с оставшимися словами в массиве
            for (int j = 0; j < words.size();) {
                //если слово является обращением исходндного
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i){
                    //добавляем в результирующий массив
                    Pair pair = new Pair();
                    pair.first = words.get(i);
                    pair.second = words.get(j);
                    result.add(pair);
                    //удаляем найденные слова
                    words.remove(j);
                    words.remove(i);
                    //обнуляем счетчик
                    j = 0;
                }
                else{
                    j++;
                }
            }
        }

        for (Pair pair: result)
            System.out.println(pair.toString());

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
