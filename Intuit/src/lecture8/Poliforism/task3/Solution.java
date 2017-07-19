package lecture8.Poliforism.task3;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        //Child c = new Child();
        System.out.println(Child.a);
        //Parent p = c;
        System.out.println(Parent.a);
    }
}

class Parent {
    static int a = 2;
}
class Child extends Parent {
    static int a = 3;
}

