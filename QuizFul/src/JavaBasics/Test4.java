package JavaBasics;

/**
 * Выберите из приведенных единственный верный вариант вывода приложения при запуске его командой
 * "java Test 1 two 3".
 * При запуске из командной строки: java - программа, Test - класс, остальное параметры (1 two 3)
 */
public class Test4 {
    static public void main(String[] args) {
        try {
            int k = Integer.parseInt(args[1]);
            System.out.println(args[k]);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
