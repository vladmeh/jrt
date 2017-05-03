package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.

Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.


ПРОВЕРКУ ПРОШЛО НО ... ОШИБКА КОМПИЛЯЦИИ
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        reader.close();

        BufferedReader fr1 = new BufferedReader(new FileReader(fn1));
        List<String> list1 = new ArrayList<>();
        while (fr1.ready()){
            list1.add(fr1.readLine());
        }
        fr1.close();

        BufferedReader fr2 = new BufferedReader(new FileReader(fn2));
        List<String> list2 = new ArrayList<>();
        while (fr2.ready()){
            list2.add(fr2.readLine());
        }
        fr2.close();

        int i = 0;
        //пока в первом списке есть строки
        while (i < list1.size()) {
            //если второй список меньше первого
            if (i == list2.size()) {
                //добавляем оставшиеся элементы как удаленные
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                //удаляем верхнюю строку из первого списка
                list1.remove(i);
            }
            //сравниваем строки без учета регистра
            //если строки в обоих списках равны
            else if (list1.get(i).equalsIgnoreCase(list2.get(i))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                //удаляем строки из обоих списков
                list1.remove(i);
                list2.remove(i);
            }
            //иначе сравниваем верхнюю строку первого списка со следующей строкой вторго списка
            //если они равны, то во второй список добалена строка

            else if (list1.get(i).equalsIgnoreCase(list2.get(i+1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
                //удаляем строку из второго списка
                list2.remove(i);
            }
            //иначе строка была удалена
            else if (!list1.get(i).equalsIgnoreCase(list2.get(i))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                list1.remove(i);
            }
        }
        //второй список больше первого и в нем остались строки
        //добавляем их как новые
        if(list1.size() == 0 && list2.size() > 0){
            for (int j = 0; j < list2.size(); j++) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                list2.remove(j);
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
