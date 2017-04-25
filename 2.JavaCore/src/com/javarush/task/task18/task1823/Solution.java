package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты

Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String fileName = reader.readLine();
            if ("exit".equals(fileName)) break;
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(this.fileName);

                Map<Integer, Integer> map = new HashMap<>();
                while (inputStream.available() > 0){
                    int data = inputStream.read();

                    if (map.containsKey(data))
                        map.put(data, map.get(data)+1);
                    else
                        map.put(data, 1);
                }
                inputStream.close();

                int n = 0;
                for (Map.Entry<Integer, Integer> entry: map.entrySet())
                    if (entry.getValue() > n) n = entry.getValue();

                for (Map.Entry<Integer, Integer> entry: map.entrySet())
                    if (entry.getValue().equals(n))
                        resultMap.put(this.fileName, entry.getKey());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
