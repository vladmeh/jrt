package com.javarush.task.level19;

import java.nio.charset.Charset;
import java.util.*;

import static net.mindview.util.Print.*;

/**
 * Буфер содержит обычные байты, следовательно,
 * для превращения их в символы мы должны либо
 * кодировать их по мере помещения в буфер,
 * либо декодировать их при извлечении из буфера.
 * Это можно сделать с помощью класса java.nio.charset.Charset,
 * который предоставляет инструменты для преобразования
 * многих различных типов в наборы символов:
 *
 * Перечисление кодировок и их символических имен
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charSets =
                Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while(it.hasNext()) {
            String csName = it.next();
            printnb(csName);
            Iterator aliases =
                    charSets.get(csName).aliases().iterator();
            if(aliases.hasNext())
                printnb(": ");
            while(aliases.hasNext()) {
                printnb(aliases.next());
                if(aliases.hasNext())
                    printnb(", ");
            }
            print();
        }
    }
}
