package JavaBasics;

/**
 * Возникнет java.lang.NullPointerException в 5-й строке, поскольку компилятор преобразует выражение
 * final int int1 = oInt1; в final int int1 = oInt1.intValue();
 */
public class Test15 {
    public static void main(String[] args) {
        Integer oInt1 = null;
        Integer oInt2 = 0;
        final int int1 = oInt1;
        final int int2 = oInt2;
        System.out.println(int1 == int2);
    }
}
