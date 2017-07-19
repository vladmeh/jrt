package lecture8.test.task2;

/**
 * @autor mvl on 19.07.2017.
 */
public class SomeClass {
    int a = b;
    static int b = 5;

    public static void main(String[] args) {
        System.out.println(new SomeClass().a);
        System.out.println(SomeClass.b);
    }
}
