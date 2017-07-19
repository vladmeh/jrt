package lecture8.test.task6;

/**
 * @autor mvl on 19.07.2017.
 */
class Parent {
    public void print() {
        //System.out.println(x);
    }
}
class Child extends Parent {
    int x = 3;
    public static void main(String[] args) {
        Parent c = new Child();
        c.print();
    }
}
