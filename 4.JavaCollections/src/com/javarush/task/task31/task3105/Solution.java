package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/* 
Добавление файла в архив
*/
public class Solution {
    private static Map<ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        while (zipInputStream.available() > 0) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;

            while ((count = zipInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, count);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            entryMap.put(zipEntry, bytes);
        }
        zipInputStream.close();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOutputStream.putNextEntry(new ZipEntry("new/" + Paths.get(args[0]).getFileName().toString()));
        Files.copy(Paths.get(args[0]), zipOutputStream);

        for (Map.Entry<ZipEntry, byte[]> zipEntryEntry : entryMap.entrySet()) {
            if (!Paths.get(args[0]).getFileName().toString().equals(zipEntryEntry.getKey().getName())) {
                zipOutputStream.putNextEntry(new ZipEntry(zipEntryEntry.getKey().getName()));
                zipOutputStream.write(zipEntryEntry.getValue());
            }
        }
        zipOutputStream.close();

    }
}
