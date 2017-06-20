package com.javarush.task.task31.task3110;

import java.io.*;
import java.nio.file.Paths;

/**
 * @autor mvl on 20.06.2017.
 */
public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String zipFile = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(zipFile));

        String fileName = reader.readLine();
        zipFileManager.createZip(Paths.get(fileName));
    }
}
