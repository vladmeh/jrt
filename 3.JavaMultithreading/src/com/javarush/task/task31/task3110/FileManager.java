package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 20.06.2017.
 */
public class FileManager {
    private Path rootPath;
    private List<Path> fileList = new ArrayList<>();

    public FileManager(Path rootPath) throws IOException{
        this.rootPath = rootPath;
        collectFileList(rootPath);
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }

        if (Files.isDirectory(path)){
            try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path))
            {
                for (Path file: directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }

    public List<Path> getFileList() {
        return fileList;
    }
}
