package lecture7.test;

/**
 * @autor mvl on 18.07.2017.
 */
public class ConversionType {
    public static void main(String[] args) {
        long a = 111111111111L;
        float f = a;
        long b = 11111L;
        float d = b;
        System.out.println( a == (long) f);
        System.out.println( b == (long) d);

        ConversionType c = new ConversionType();
        c.f1(1, 1);

        ConversionType s = new SomeClass2();
        SomeClass2 s2 = new SomeClass2();
        s2.print();
        //s.print();

        /*Wolf wolf = new Wolf();
        Animal animal = (Animal)wolf;
        Rabbit rabbit = (Rabbit)animal;

        byte cb = (char)5 + 'a';
        short sb = (short)(2 + 3);
        char c2 = (byte)5 + 'a';*/

        /*byte bc = 100 - 100;
        bc = 100 + 200;
        bc = 100 * 100;*/

        byte cb = (char)50;
        byte cb2 = 'a';
        /*byte cb3 = (char)150;
        byte cb4 = (char)150 + "a";
        byte cb5 = (long)50;*/
    }

    public void f1(int b, long c) {
        System.out.println("1");
    }
    public void f1(long b, int c) {
        System.out.println("2");
    }
    public void f1(int b, int c) {
        System.out.println("3");
    }
    public void f1(long b, long c) {
        System.out.println("4");
    }
}

class SomeClass2 extends ConversionType {
    public void print() {
        System.out.println("message");
    }
}

class Animal{}
class Wolf extends Animal{}
class Rabbit extends Animal{}
