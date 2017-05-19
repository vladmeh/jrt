package JavaBasics;

/**
 * Внимательность
 */
public class Test9 {
    public static void main(String[] args) {
        long x = 5;
        long y = 2;
        //byte b = (byte) x / y; - не скомпилируется
        byte b = (byte) (x / y);
    }
}
