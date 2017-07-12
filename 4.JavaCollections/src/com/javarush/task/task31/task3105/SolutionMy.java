package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class SolutionMy {
    private static List<ZipEntry> list = new ArrayList<>();
    private static Map<ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            System.out.println("Uses ZIP compression to compress\nthe file to ./testFiles/test.zip");
            System.exit(1);
        }
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(args[1]));

        zip.putNextEntry(new ZipEntry("a.txt"));
        File file = new File("testFiles/invers.txt");
        Files.copy(file.toPath(), zip);

        zip.putNextEntry(new ZipEntry("b.txt"));
        File file1 = new File("testFiles/data2.txt");
        Files.copy(file1.toPath(), zip);

        zip.putNextEntry(new ZipEntry("Data.txt"));
        File file2 = new File("testFiles/Data.txt");
        Files.copy(file2.toPath(), zip);

        zip.close();*/


        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);
            }
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))) {

            Path addFile = Paths.get(args[0]);

            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {
                if (!addFile.getFileName().toString().equals(zipEntry.getKey().getName())){
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());
                }
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + addFile.getFileName().toString()));
            Files.copy(addFile, zipOutputStream);
        }

    }
}
