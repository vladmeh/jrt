package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки

Исправить функциональность в соответствии с требованиями.

Программа должна:
1. Переписать все байты одного файла в другой одним куском.
2. Закрывать потоки ввода-вывода.

Подсказка:
4 ошибки.


Требования:
1. Программа должна использовать классы FileInputStream и FileOutputStream.
2. Программа должна переписать все байты одного файла в другой одним куском.
3. Потоки FileInputStream и FileOutputStream должны быть закрыты.
4. Нужно исправить 4 ошибки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем поток чтения байт из файла
        FileInputStream inputStream = new FileInputStream("d:/JavaRush/test1.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("d:/JavaRush/result2.txt");

        //если размер файла больше нуля (файл не пустой)
        if (inputStream.available() > 0) {//3,4
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            //читаем весь файл одним куском в переменную buffer
            /*@Todo исходник: int count = inputStream.read(buffer);*/
            //но т.к. мы знаем точно какого размера у нас блок записи/чтения
            //то реальное количество байт нам ни к чему
            inputStream.read(buffer);

            //записываем весь блок во второй поток (во торой файл)
            /*@Todo исходник: outputStream.write(buffer, 0, count);*/
            outputStream.write(buffer);
        }

        //закрываем оба потока.
        inputStream.close(); //1
        outputStream.close();//2
    }
}
