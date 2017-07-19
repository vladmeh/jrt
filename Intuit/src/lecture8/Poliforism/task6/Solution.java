package lecture8.Poliforism.task6;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Parent p = new Child();
        p.print();
    }
}
class Parent {
    public int getValue() {
        return 0;
    }
    public void print() {
        System.out.println(getValue());
    }
}

class Child extends Parent {
    public int getValue() {
        return 1;
    }
}
