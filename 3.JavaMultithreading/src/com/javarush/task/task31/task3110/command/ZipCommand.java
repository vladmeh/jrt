package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @autor mvl on 20.06.2017.
 */
public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws IOException {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}
