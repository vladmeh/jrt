package com.javarush.task.task19.task1916;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvl on 03.05.2017.
 */
public class MySolution {
    public static List<LineItem> lines = new ArrayList<>();
    public static List<String> list1 = new ArrayList<>();
    public static List<String> list2 = new ArrayList<>();

    static {
        try {
            list1 = Files.readAllLines(Paths.get("testfiles/change1.txt"), StandardCharsets.UTF_8);
            list2 = Files.readAllLines(Paths.get("testfiles/change2.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while (!list1.isEmpty() || !list2.isEmpty()){
            String lf1 = list1.get(0);
            String lf2 = list2.get(0);
            if (lf1.equals(lf2)){
                lines.add(new LineItem(Type.SAME, lf1));
                list1.remove(0);
                list2.remove(0);
            }
            else if (list2.size() > 1 && lf1.equals(list2.get(1))){
                lines.add(new LineItem(Type.ADDED, lf2));
                list2.remove(0);
            }
            else {
                lines.add(new LineItem(Type.REMOVED, lf1));
                list1.remove(0);
            }
        }

        if (!list1.isEmpty()){
            for (String line: list1)
                lines.add(new LineItem(Type.REMOVED, line));
        }

        if (!list2.isEmpty()){
            for (String line: list2)
                lines.add(new LineItem(Type.ADDED, line));
        }

        for (LineItem line: lines)
            System.out.println(line.type + " " + line.line);
    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
