package lecture8.test.task3;

/**
 * @autor mvl on 19.07.2017.
 */
public class SomeClass {
    int b = this.a;
    int a = 5;
    {
        System.out.print(a);
        System.out.print(b);
    }
    public static void main(String[] args) {
        new SomeClass();
    }
}
