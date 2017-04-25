package com.javarush.task.task18.task1825;

/* 
Собираем файл

Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом «end«.
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, …, в конце — последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new TreeMap<>();

        while (true){
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;

            System.out.println(fileName.endsWith("part"));
            //map.put(fileName, null);
        }

        reader.close();

        /*FileOutputStream resultFile = new FileOutputStream("lion.txt");

        for (Map.Entry<String, String> entry: map.entrySet()){
            FileInputStream partFile = new FileInputStream(entry.getKey());
            byte[] buffer = new byte[partFile.available()];
            partFile.read(buffer);
            resultFile.write(buffer);

            partFile.close();
        }

        resultFile.close();*/
    }
}
