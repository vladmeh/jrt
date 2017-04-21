package net.mindview.util;

import java.io.*;
import java.util.*;
/**
 * Статические функции для построчного считывания и записи
 * текстовых файлов,- а также манипуляции файлом как списком ArrayList
 */
public class TextFile extends ArrayList<String>{
    /**
     * Читает файл в виде одной строки
     * Метод присоединяет каждую строку к StringBuilder,
     * а за ней присоединяется перевод строки, удаленный при чтении
     *
     * @param fileName
     * @return String
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     * Открывает файл и записывает в него текст.
     *
     * @param fileName
     * @param text
     */
    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Конструктор использует метод read() для превращения файла в String,
     * после чего он вызывает метод String.split(),
     * чтобы разбить результат на строки.
     *
     * @param fileName
     * @param splitter
     */
    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // Regular expression split() often leaves an empty
        // String at the first position:
        if(get(0).equals("")) remove(0);
    }

    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for(String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Simple test:
    public static void main(String[] args) {
        String file = read("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\net\\mindview\\util\\TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(
                new TextFile("D:\\JavaRush\\JavaRushTasks\\Java4thEdition\\src\\net\\mindview\\util\\TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}
