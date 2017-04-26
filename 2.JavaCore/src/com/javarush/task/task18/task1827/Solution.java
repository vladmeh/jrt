package com.javarush.task.task18.task1827;

/* 
Прайсы

CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846 Шорты пляжные синие 159.00 12
198478 Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static String fileName;

    static {
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


    public static void main(String[] args) throws Exception {

        if (args[0].equals("-c") && args.length == 4){
            create(args[1], args[2], args[3]);
        }
    }

    public static void create(String productName, String price, String quantity) throws IOException {
        List<String> list = new ArrayList<>();
        //Определяем id нашего продукта
        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");

        int newId = 0;
        while (in.hasNext()){
            String line = in.nextLine();
            list.add(line);
            int id = getProductId(line);
            if (newId < id)
                newId = id;
        }
        //Новый Id
        String id = Integer.toString(++newId);

        //закрываем этот поток
        in.close();

        //Формируем новую строку
        id = stringFormat(id, 8);
        productName = stringFormat(productName, 30);
        price = stringFormat(price, 8);
        quantity = stringFormat(quantity, 4);
        String newString = String.format("%s%s%s%s", id, productName, price, quantity);
        list.add(newString);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (String line: list)
            bufferedWriter.write(line+System.getProperty("line.separator"));

        bufferedWriter.close();
    }


    public static int getProductId(String line){
        int id = Integer.parseInt(line.substring(0,8).trim());
        return id;
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
