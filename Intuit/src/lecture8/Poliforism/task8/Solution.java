package lecture8.Poliforism.task8;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        //Child c = new Child();
        System.out.println(Child.getValue());
        //Parent p = c;
        System.out.println(Parent.getValue());
    }
}

class Parent {
    static public int getValue() {
        return 0;
    }
}

class Child extends Parent {
    static public int getValue() {
        return 1;
    }
}
