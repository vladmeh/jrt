package lecture8.Poliforism.task2;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        new Child().printX();
    }
}

class Parent {
    int x=0;
    public void printX() {
        System.out.println(x);
    }
}
class Child extends Parent {
    int x=-1;
}
