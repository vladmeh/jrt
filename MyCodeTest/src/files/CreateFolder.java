package files;

import java.io.File;

/**
 * Created by mvl on 23.05.2017.
 */
public class CreateFolder {
    public static void main(String[] args) {
        File folder = new File("testFiles/testFolder");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}
