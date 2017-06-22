package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type View.
 *
 * @autor mvl on 21.06.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    /**
     * Instantiates a new View.
     */
    public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Gets controller.
     *
     * @return the controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Sets controller.
     *
     * @param controller the controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Gets undo listener.
     *
     * @return the undo listener
     */
    public UndoListener getUndoListener() {
        return undoListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;
        }
    }

    /**
     * Инициализация представления.
     */
    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Exit.
     */
    public void exit(){
        controller.exit();
    }

    /**
     * Init menu bar.
     */
    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);

        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    /**
     * Init editor.
     */
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(800, 800));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Init gui.
     */
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    /**
     * Selected tab changed.
     */
    public void selectedTabChanged(){
        switch (tabbedPane.getSelectedIndex()){
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }

        resetUndo();
    }

    /**
     * Can undo boolean.
     *
     * @return the boolean
     */
    public boolean canUndo() {
        return undoManager.canUndo();
    }

    /**
     * Can redo boolean.
     *
     * @return the boolean
     */
    public boolean canRedo() {
        return undoManager.canRedo();
    }

    /**
     * Undo.
     */
    public void undo(){
        try{
            undoManager.undo();
        }
        catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }

    /**
     * Redo.
     */
    public void redo(){
        try{
            undoManager.redo();
        }
        catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Reset undo.
     */
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    /**
     * Is html tab selected boolean.
     *
     * @return the boolean
     */
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    /**
     * Select html tab.
     */
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    /**
     * Update.
     */
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    /**
     * Show about.
     */
    public void showAbout(){
        JOptionPane.showMessageDialog(this, "HTMLEditor", "About", JOptionPane.INFORMATION_MESSAGE);
    }
}
