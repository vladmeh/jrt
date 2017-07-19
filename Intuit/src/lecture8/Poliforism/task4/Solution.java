package lecture8.Poliforism.task4;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Child.a = 10;
        Parent.a = 5;
        System.out.println(Child.a);
    }
}
class Parent {
    static int a;
}

class Child extends Parent {

}
