package files;

/**
 * Created by mvl on 24.05.2017.
 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class CopyFolderNio {
    public static void main(String[] args) {
        Path pathSource = Paths.get("./testFiles");
        Path pathDestination = Paths.get("./testFiles_CopyNio");
        try {
            Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource, pathDestination));
            System.out.println("Files copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyFileCopyVisitor extends SimpleFileVisitor {
    private Path source, destination;

    public MyFileCopyVisitor(Path s, Path d) {
        this.source = s;
        this.destination = d;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        Path newd = destination.resolve(source.relativize((Path) dir));
        try {
            Files.copy((Path) dir, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        Path newd = destination.resolve(source.relativize((Path) file));
        try {
            Files.copy((Path) file, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }


    /*public FileVisitResult visitFile(Path path,
                                     BasicFileAttributes fileAttributes) {
        Path newd = destination.resolve(source.relativize(path));
        System.out.println(newd.getFileName().toString());
        *//*try {
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }*//*
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path,
                                             BasicFileAttributes fileAttributes) {
        Path newd = destination.resolve(source.relativize(path));
        System.out.println(newd.toString());
        *//*try {
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }*//*
        return FileVisitResult.CONTINUE;
    }*/
}
