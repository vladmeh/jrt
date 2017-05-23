package files;

import java.io.File;
import java.util.*;

/**
 * Ищем каталог на компютере по имени
 */
public class SearchFolder {
    public static void main(String[] args) {
        File path = new File(".");

        List<File> res = new ArrayList<>();

        search(path, res, args[0]);

        if (res.size() != 0)
            for (File dir : res)
                System.out.println(dir.getPath());
        else
            System.out.println("директория не найдена");

    }

    public static void search(File topDirectory, List<File> res, String mask){
        File[] list = topDirectory.listFiles();
        for (File aList : list) {
            if (aList.isDirectory()){
                if (aList.getName().equals(mask))
                    res.add(aList);
                search(aList, res, mask);
            }
        }
    }
}
