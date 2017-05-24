package files;

import java.io.*;

/**
 * Копирование директории совсем ее содержимым
 */
public class CopyDirectories {
    public static void main(String[] args) {
        File source = new File("testFiles");
        File target = new File("testFiles_CopyStream");

        // копируем с помощью потоков
        long start = System.currentTimeMillis();
        try {
            copyDirectoryStream(source, target);
            System.out.println(
                    new StringBuilder()
                            .append("Время копирования директории с помощью потоков = ")
                            .append(System.currentTimeMillis() - start).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Используем потоки
    private static void copyDirectoryStream(File sourceLocation , File targetLocation)
            throws IOException {

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            if (children != null) {
                for (int i=0; i<children.length; i++)
                    copyDirectoryStream(new File(sourceLocation, children[i]),
                            new File(targetLocation, children[i]));
            }
        }
        else {
            try(
                InputStream in = new FileInputStream(sourceLocation);
                OutputStream out = new FileOutputStream(targetLocation)
            ){
                byte[] buf;
                buf = new byte[in.available()];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
        }
    }

}