package recursive.lect34_01.task4;

import java.io.File;

/**
 * @autor mvl on 26.07.2017.
 */
public class Solution {
    public static void main(String[] args)
    {
        printAllFiles(new File("./testFiles"));
    }

    public static void printAllFiles(File dir)
    {
        for (File file : dir.listFiles())
        {
            if (file.isDirectory())
                printAllFiles(file);
            else
                System.out.println(file.getAbsolutePath());
        }
    }
}
