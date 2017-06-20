package com.javarush.task.task31.task3110;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @autor mvl on 20.06.2017.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        try(
            ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
            InputStream inputStream = Files.newInputStream(source)
        ){
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);

            int c;
            while ((c = inputStream.read()) != -1){
                zipOutputStream.write(c);
            }
        }
    }
}
