package lecture8.Poliforism.task1;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.a);
        Parent p = c;
        System.out.println(p.a);
        System.out.println(c.c);
    }
}

class Parent {
    int a=2;
}
class Child extends Parent {
    int a=3;
    int c = super.a;
}
