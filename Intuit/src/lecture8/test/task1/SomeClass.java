package lecture8.test.task1;

/**
 * @autor mvl on 19.07.2017.
 */
public class SomeClass {
    static void perform() {
        System.out.println("perform");
    }
    private static SomeClass c;
    public static void main(String[] args) {
        SomeClass.c.perform();
    }
}
