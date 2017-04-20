package com.javarush.task.level18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Для преобразования строки в массив байтов,
 * пригодный для помещения в поток ByteArrayInputStream,
 * в классе String предусмотрен метод getBytes().
 * Полученный ByteArrayInputStream представляет собой поток InputStream,
 * подходящий для передачи DataInputStream.
 *
 * При побайтовом чтении символов из форматированного потока DataInputStream
 * методом readByte() любое полученное значение будет считаться действительным,
 * поэтому возвращаемое значение неприменимо для идентификации конца потока.
 *
 * Вместо этого можно использовать метод available(), который сообщает,
 * сколько еще осталось символов.
 */
public class FormattedMemoryInput {
    public static void main(String[] args)
            throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\com\\javarush\\task\\level18\\FormattedMemoryInput.java").getBytes()));
            while(true)
                System.out.print((char)in.readByte());
        } catch(EOFException e) {
            System.err.println("End of stream");
        }
    }
}
