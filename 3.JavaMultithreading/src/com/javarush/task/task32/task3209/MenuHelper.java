package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * @autor mvl on 21.06.2017.
 */
public class MenuHelper {

    /** добавляет в parent новый пункт меню*/
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);

        return menuItem;
    }

    /** добавляет в parent новый пункт меню с текстом text и действием action*/
    public static JMenuItem addMenuItem(JMenu parent, String text, Action action){
        JMenuItem menuItem = addMenuItem(parent, action);
        menuItem.setText(text);

        return menuItem;
    }

    /** добавляет в parent новый пункт меню с действием action*/
    public static JMenuItem addMenuItem(JMenu parent, Action action){
        JMenuItem menuItem = new JMenuItem(action);
        parent.add(menuItem);

        return menuItem;
    }


    /** инициализация меню помощи*/
    public static void initHelpMenu(View view, JMenuBar menuBar){}

    /** инициализация меню выбора*/
    public static void initFontMenu(View view, JMenuBar menuBar){}

    /** инициализация меню выбора цвета*/
    public static void initColorMenu(View view, JMenuBar menuBar){}

    /** инициализация меню выравнивания*/
    public static void initAlignMenu(View view, JMenuBar menuBar){}

    /** инициализация меню выбора */
    public static void initStyleMenu(View view, JMenuBar menuBar){}

    /** инициализация меню редактирования */
    public static void initEditMenu(View view, JMenuBar menuBar){}

    /** инициализация меню Файл*/
    public static void initFileMenu(View view, JMenuBar menuBar){}
}
