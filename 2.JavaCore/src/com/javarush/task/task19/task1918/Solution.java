package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String tmp = "Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span>";

        Pattern p = Pattern.compile("<span(.)*?>(?=(?:.*<(\\1)>)?)</span>", Pattern.MULTILINE);
        Pattern p1 = Pattern.compile("<([^> ]+)>(?=(?:.*<(\\1)>)?)", Pattern.MULTILINE);
        Pattern p2 = Pattern.compile("<(span(.)*?)>\\p{all}?</span>", Pattern.MULTILINE);
        Pattern p3 = Pattern.compile("(<[^> /!-]+>)(?![\\s\\S]*\\1)", Pattern.MULTILINE);

        Matcher m = p3.matcher(tmp);
        List<String> exclude = new ArrayList<String>();
        while ( m.find() ) {
            System.out.println(m.group());
            /*if ( exclude.indexOf( m.group(1).toLowerCase() ) == -1 ) {
                System.out.println( m.group() );
            }*/
        }
    }
}
