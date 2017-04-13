package com.javarush.task.task17.task1704;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки 2

Класс Note будет использоваться нитями. Поэтому сделай так, чтобы вcе методы были синхронизированы


Требования:
1. Метод addNote() должен добавлять записки в список notes.
2. Метод removeNote() должен удалять записку из списка notes.
3. Метод addNote() должен быть синхронизирован.
4. Метод removeNote() должен быть синхронизирован.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public synchronized void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public synchronized void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }
}
