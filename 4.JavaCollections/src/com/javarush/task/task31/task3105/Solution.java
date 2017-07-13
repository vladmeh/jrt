package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        File addFile = new File(args[0]);
        File zipFile = new File(args[1]);
        Map<String, byte[]> entryMap = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry.getName(), bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
            zipOutputStream.putNextEntry(new ZipEntry("new/" + addFile.getName()));
            Files.copy(addFile.toPath(), zipOutputStream);

            for (Map.Entry<String, byte[]> entry : entryMap.entrySet()) {
                if (!entry.getKey().equals(addFile.getName())) {
                    zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                    zipOutputStream.write(entry.getValue());
                    zipOutputStream.closeEntry();
                }
            }
        }
        catch (Exception e){
            e. printStackTrace();
        }
    }
}
