package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize = -1, maxSize = -1;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isPartOfName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            isPartOfName = false;

        boolean isPartOfContent = true;
        String content = new String(Files.readAllBytes(file));
        if (partOfContent != null && !content.contains(partOfContent))
            isPartOfContent = false;

        boolean isMinSize = true;
        if (minSize != -1 && Files.size(file) < minSize)
            isMinSize = false;

        boolean isMaxSize = true;
        if (maxSize != -1 && Files.size(file) > maxSize)
            isMaxSize = false;

        if (isPartOfName && isPartOfContent && isMinSize && isMaxSize)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
