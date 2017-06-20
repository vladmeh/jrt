package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.util.List;

/**
 * @autor mvl on 20.06.2017.
 */
public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");

        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();

        for (FileProperties fileProperties: filePropertiesList)
            ConsoleHelper.writeMessage(fileProperties.toString());

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
