package com.javarush.task.level18;

/**
 * Преобразование System out в символьный поток PrintWriter.
 *
 */
import java.io.*;

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
}
