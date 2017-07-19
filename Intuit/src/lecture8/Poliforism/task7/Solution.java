package lecture8.Poliforism.task7;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.getValue());
    }
}

class Parent {
    protected int getValue() {
        return 0;
    }
}

class Child extends Parent {
    /* ??? */
    protected int getValue() {
        return 1;
    }
}
