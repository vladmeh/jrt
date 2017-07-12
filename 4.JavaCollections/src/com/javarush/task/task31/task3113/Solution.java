package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    private static int countDir = 0;
    private static int countFiles = 0;
    private static long sizeDir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path folder = Paths.get(reader.readLine());
        reader.close();

        if (Files.isDirectory(folder)) {
            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countFiles++;
                    sizeDir += attrs.size();

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(folder))
                        countDir++;

                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + countDir);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + sizeDir);
        } else {
            System.out.println(folder.normalize().toAbsolutePath().toString() + " - не папка");
        }


    }
}
