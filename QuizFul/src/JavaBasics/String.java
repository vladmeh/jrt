package JavaBasics;

/**
 * Возникнет ошибка в строке 1, поскольку тип java.lang.String неприводим к типу String
 */
public class String {
    //static String[][]String = {{"String"}};       // 1

    static {
        System.out.println(String.class);         // 2
    }

    public static void main(String[] args) {      // 3
        System.out.println(String.class);         // 4
    }
}
