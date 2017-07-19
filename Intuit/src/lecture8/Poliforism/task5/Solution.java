package lecture8.Poliforism.task5;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.getValue());
        Parent p = c;
        System.out.println(p.getValue());
    }
}
class Parent {
    public int getValue() {
        return 0;
    }
}
class Child extends Parent {
    public int getValue() {
        return 1;
    }
}
