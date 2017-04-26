package com.javarush.task.task18.task1828;

/* 
Прайсы 2

CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id — 8 символов
productName — название товара, 30 chars (60 bytes)
price — цена, 8 символов
quantity — количество, 4 символа
-u — обновляет данные товара с заданным id
-d — производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution{

    private static String fileName;

    static {
        readFileConsole();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 0){
            int productId = Integer.parseInt(args[1]);
            switch (args[0]){
                case "-u":
                    update(productId, args[2], args[3], args[4]);
                    break;
                case "-d":
                    delete(productId);
                    break;
            }

        }
    }

    private static void delete(int productId) throws IOException {
        List<String> lines = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
        while (in.hasNext()){
            String line = in.nextLine();
            int id = Integer.parseInt(line.substring(0,8).trim());
            if (id != productId)
                lines.add(line);
        }
        in.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines)
            bufferedWriter.write(line + System.getProperty("line.separator"));

        bufferedWriter.close();
    }

    public static void update(int productId, String productName, String price, String quantity) throws IOException {
        List<String> lines = new ArrayList<>();
        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");

        while (in.hasNext()){
            String line = in.nextLine();
            int id = Integer.parseInt(line.substring(0,8).trim());
            if (id == productId){
                line = String.format(
                        "%s%s%s%s",
                        stringFormat(Integer.toString(id), 8),
                        stringFormat(productName, 30),
                        stringFormat(price, 8),
                        stringFormat(quantity, 4)
                );
            }
            lines.add(line);
        }

        in.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines)
            bufferedWriter.write(line + System.getProperty("line.separator"));

        bufferedWriter.close();
    }

    public static void readFileConsole(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String stringFormat(String string, int length){
        if (string.length() > length)
            string = string.substring(0, length);

        if (string.length() < length)
            while (string.length() < length)
                string = string + " ";

        return string;
    }
}
