package lecture8.test.task5;

/**
 * @autor mvl on 19.07.2017.
 */
class Parent {
    int x = 2;
    public void print() {
        System.out.println(x);
    }
}
class Child extends Parent {
    int x = 3;
    public static void main(String[] args) {
        new Child().print();
    }
}
