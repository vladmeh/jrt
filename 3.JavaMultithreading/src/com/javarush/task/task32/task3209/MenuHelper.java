package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.actions.*;
import com.javarush.task.task32.task3209.listeners.TextEditMenuListener;
import com.javarush.task.task32.task3209.listeners.UndoMenuListener;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Menu helper.
 * Вспомогательный класс для инициализации и настройки меню.
 */
public class MenuHelper {
    /**
     * Add menu item j menu item.
     *
     * @param parent         the parent
     * @param text           the text
     * @param actionListener the action listener
     * @return the j menu item
     */
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    /**
     * Add menu item j menu item.
     *
     * @param parent the parent
     * @param text   the text
     * @param action the action
     * @return the j menu item
     */
    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem menuItem = addMenuItem(parent, action);
        menuItem.setText(text);
        return menuItem;
    }

    /**
     * Add menu item j menu item.
     *
     * @param parent the parent
     * @param action the action
     * @return the j menu item
     */
    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem menuItem = new JMenuItem(action);
        parent.add(menuItem);
        return menuItem;
    }

    /**
     * Инициализация меню помощи.
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initHelpMenu(View view, JMenuBar menuBar) {
        JMenu helpMenu = new JMenu("Помощь");
        menuBar.add(helpMenu);

        addMenuItem(helpMenu, "О программе", view);
    }

    /**
     * Инициализация меню выбора шрифта.
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initFontMenu(View view, JMenuBar menuBar) {
        JMenu fontMenu = new JMenu("Шрифт");
        menuBar.add(fontMenu);

        JMenu fontTypeMenu = new JMenu("Шрифт");
        fontMenu.add(fontTypeMenu);

        String[] fontTypes = {Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED, Font.DIALOG, Font.DIALOG_INPUT};
        for (String fontType : fontTypes) {
            addMenuItem(fontTypeMenu, fontType, new StyledEditorKit.FontFamilyAction(fontType, fontType));
        }

        JMenu fontSizeMenu = new JMenu("Размер шрифта");
        fontMenu.add(fontSizeMenu);

        String[] fontSizes = {"6", "8", "10", "12", "14", "16", "20", "24", "32", "36", "48", "72"};
        for (String fontSize : fontSizes) {
            addMenuItem(fontSizeMenu, fontSize, new StyledEditorKit.FontSizeAction(fontSize, Integer.parseInt(fontSize)));
        }

        fontMenu.addMenuListener(new TextEditMenuListener(view));
    }

    /**
     * Init color menu.
     * Инициализация меню выбора цвета
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initColorMenu(View view, JMenuBar menuBar) {
        JMenu colorMenu = new JMenu("Цвет");
        menuBar.add(colorMenu);

        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Красный", Color.red));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Оранжевый", Color.orange));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Желтый", Color.yellow));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Зеленый", Color.green));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Синий", Color.blue));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Голубой", Color.cyan));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Пурпурный", Color.magenta));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction("Черный", Color.black));

        colorMenu.addMenuListener(new TextEditMenuListener(view));
    }

    /**
     * Init align menu.
     * Инициализация меню выравнивания
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initAlignMenu(View view, JMenuBar menuBar) {
        JMenu alignMenu = new JMenu("Выравнивание");
        menuBar.add(alignMenu);

        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По левому краю", StyleConstants.ALIGN_LEFT));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По центру", StyleConstants.ALIGN_CENTER));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По правому краю", StyleConstants.ALIGN_RIGHT));

        alignMenu.addMenuListener(new TextEditMenuListener(view));
    }

    /**
     * Init style menu.
     * Инициализация меню выбора стиля текста
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initStyleMenu(View view, JMenuBar menuBar) {
        JMenu styleMenu = new JMenu("Стиль");
        menuBar.add(styleMenu);

        addMenuItem(styleMenu, "Полужирный", new StyledEditorKit.BoldAction());
        addMenuItem(styleMenu, "Подчеркнутый", new StyledEditorKit.UnderlineAction());
        addMenuItem(styleMenu, "Курсив", new StyledEditorKit.ItalicAction());

        styleMenu.addSeparator();

        addMenuItem(styleMenu, "Подстрочный знак", new SubscriptAction());
        addMenuItem(styleMenu, "Надстрочный знак", new SuperscriptAction());
        addMenuItem(styleMenu, "Зачеркнутый", new StrikeThroughAction());

        styleMenu.addMenuListener(new TextEditMenuListener(view));
    }

    /**
     * Init edit menu.
     * Инициализация меню редактирования текста
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initEditMenu(View view, JMenuBar menuBar) {
        JMenu editMenu = new JMenu("Редактировать");
        menuBar.add(editMenu);

        JMenuItem undoItem = addMenuItem(editMenu, "Отменить", new UndoAction(view));
        JMenuItem redoItem = addMenuItem(editMenu, "Вернуть", new RedoAction(view));
        addMenuItem(editMenu, "Вырезать", new DefaultEditorKit.CutAction());
        addMenuItem(editMenu, "Копировать", new DefaultEditorKit.CopyAction());
        addMenuItem(editMenu, "Вставить", new DefaultEditorKit.PasteAction());

        editMenu.addMenuListener(new UndoMenuListener(view, undoItem, redoItem));
    }

    /**
     * Init file menu.
     * Инициализация меню Файл
     *
     * @param view    the view
     * @param menuBar the menu bar
     */
    public static void initFileMenu(View view, JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);

        addMenuItem(fileMenu, "Новый", view);
        addMenuItem(fileMenu, "Открыть", view);
        addMenuItem(fileMenu, "Сохранить", view);
        addMenuItem(fileMenu, "Сохранить как...", view);
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Выход", view);
    }
}
