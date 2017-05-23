package files;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * 3 способа копирования файла
 */
public class CopyFiles {

    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("testFiles/test.dat");
        File dest = new File("testFiles/testSource.dat");

        // копируем файл с помощью потоков
        long start = System.nanoTime();
        // засекаем время до выполнения копирования
        copyFileUsingStream(source, dest);
        System.out.println("Время копирования файла с помощью потоков = "+(System.nanoTime()-start));

        // копируем файл с помощью java.nio.FileChannel
        source = new File("testFiles/testSource.dat");
        dest = new File("testFiles/testChannel.dat");
        start = System.nanoTime();
        copyFileUsingChannel(source, dest);
        System.out.println("Время копирования файла с помощью java.nio.FileChannel = "+(System.nanoTime()-start));


        // копируем файл с помощью класса Files (Java 7)
        source = new File("testFiles/testChannel.dat");
        dest = new File("testFiles/testSource7.dat");
        start = System.nanoTime();
        copyFileUsingJava7Files(source, dest);
        System.out.println("Время копирования файла с помощью класса Files Java 7 = "+(System.nanoTime()-start));
    }

    //Используем потоки
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        try(
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[is.available()];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    //Используем FileChannel
    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        try(
            FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel destChannel = new FileOutputStream(dest).getChannel()
        )
        {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
    }

    //Используем класс Files (начиная с Java 7)
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

}
