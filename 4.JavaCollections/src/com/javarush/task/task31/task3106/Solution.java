package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++)
        {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++)
        {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }

        try (SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList))) {
            ZipInputStream zipInStream = new ZipInputStream(seqInStream);
            FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
            byte[] buf = new byte[1024 * 1024];
            while (zipInStream.getNextEntry() != null) {
                int count;
                while ((count = zipInStream.read(buf)) != -1) {
                    fileOutStream.write(buf, 0, count);
                }
            }
            seqInStream.close();
        }

    }
}
