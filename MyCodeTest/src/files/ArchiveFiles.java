package files;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

/* 
Добавление файла в архив
*/
public class ArchiveFiles {
    private static final String ZIP_FILE_NAME = "testFiles/test.zip";
    private static Map<String, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ArchiveFiles archiveFiles = new ArchiveFiles();
        archiveFiles.createZip(ZIP_FILE_NAME);
    }

    public void createZip(String zipFilePath) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFilePath))) {

            zip.putNextEntry(new ZipEntry("a.txt"));
            File file = new File("testFiles/invers.txt");
            Files.copy(file.toPath(), zip);

            zip.putNextEntry(new ZipEntry("b.txt"));
            File file1 = new File("testFiles/data2.txt");
            Files.copy(file1.toPath(), zip);

            zip.putNextEntry(new ZipEntry("Data.txt"));
            File file2 = new File("testFiles/Data.txt");
            Files.copy(file2.toPath(), zip);

            zip.putNextEntry(new ZipEntry("new/"));
            zip.putNextEntry(new ZipEntry("new/c"));
            File file3 = new File("testFiles/pair.txt");
            Files.copy(file3.toPath(), zip);
        }
    }

    public void addFileZip(String zipFilePath, String addFileName) throws IOException {

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
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
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath))) {

            Path addFile = Paths.get(addFileName);
            for (Map.Entry<String, byte[]> zipEntry : entryMap.entrySet()) {
                if (!addFile.getFileName().toString().equals(zipEntry.getKey())){
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey()));
                    zipOutputStream.write(zipEntry.getValue());
                }
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + addFile.getFileName().toString()));
            Files.copy(addFile, zipOutputStream);
        }
    }
}
