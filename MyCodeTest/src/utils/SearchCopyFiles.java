package utils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


/**
 * @autor mvl on 13.06.2017.
 */
public class SearchCopyFiles {
    private static final Path DIRECTORY = Paths.get("./");
    private static final String MASK = "Условие.jrtc";
    private static final String MASK_NEW = "Readme.md";

    public static void main(String[] args) throws IOException {

        Files.walkFileTree(DIRECTORY, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().equals(MASK)) {
                    Path newd = Paths.get(file.getParent() + "/" + MASK_NEW);
                    if (Files.notExists(newd)){
                        System.out.println(newd);
                        Files.copy(file, newd, StandardCopyOption.REPLACE_EXISTING);
                    }

                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
