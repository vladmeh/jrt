package JavaBasics;

/**
 *  Важно знать, что значение для переменной типа char можно задать несколькими способами:
 *  непосредственно символом, unicode-кодом этого символа, а также целым числом.
 *  Так же важно знать, что значения типа char не "склеиваются", а складываются.
 */
public class Test14 {
    public static void main(String[] args) {
        char c1 = '1';
        char c2 = '\u0031';
        char c3 = 49;
        System.out.println(c1+c2+c3);
    }
}
