package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Моя версия
*/


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class MySolution {
    public static void main(String[] args) throws IOException {
        Document htmlFile = Jsoup.parse(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\Условие.jrtc"), "UTF-8");

        Elements tag = htmlFile.getElementsByTag("span");
        System.out.println(tag.toString());
    }
}
