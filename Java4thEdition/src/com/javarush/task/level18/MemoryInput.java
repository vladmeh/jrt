package com.javarush.task.level18;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by mvl on 20.04.2017.
 */
public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\com\\javarush\\task\\level18\\MemoryInput.java"));
        int c;
        //метод read() возвращает следующий символ в формате int,
        // и для правильного вывода его необходимо предварительно преобразовать в char.
        while((c = in.read()) != -1)
            System.out.print((char)c);
    }
}
