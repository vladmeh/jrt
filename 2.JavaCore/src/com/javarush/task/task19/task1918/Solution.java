package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String tmp = "";
        while (fileReader.ready())
            tmp += fileReader.readLine();

        fileReader.close();
        String tag = args[0];

        Pattern p = Pattern.compile("<("+tag+").*?>([^< ]+)?</(\\1)>", Pattern.DOTALL);
        Pattern p1 = Pattern.compile("<("+tag+")?>.*?</(\\1)?>", Pattern.DOTALL);

        Pattern openTag = Pattern.compile("<"+ tag +".*?>");
        Pattern closeTag = Pattern.compile("</"+ tag +">");

        Matcher open = openTag.matcher(tmp);
        Matcher close = closeTag.matcher(tmp);

        while ( open.find() ) {
            System.out.println("open tag:" + open.start());
            if (close.find())
                System.out.println("close tag:" + close.start());
        }
    }
}
