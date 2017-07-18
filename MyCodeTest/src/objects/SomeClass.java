package objects;

/**
 * @autor mvl on 18.07.2017.
 */
public class SomeClass {
    public static void main(String[] args) {
        SomeClass c = new SomeClass3();
        SomeClass3 c2 = new SomeClass3();
        c2.print();
        //c.print(); Error
    }
}

class SomeClass3 extends SomeClass {
    public void print() {
        System.out.println("message");
    }
}
