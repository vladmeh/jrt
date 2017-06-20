package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.*;
import java.nio.file.*;

/**
 * @autor mvl on 20.06.2017.
 */
public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите полный путь файла в архиве:");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(sourcePath);
        ConsoleHelper.writeMessage("Удаление из архива завершено.");
    }
}
