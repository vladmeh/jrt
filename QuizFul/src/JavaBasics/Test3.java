package JavaBasics;

/**
 * Created by mvl on 19.05.2017.
 */
public class Test3 {
    int i = 1;

    void add(int i){
        i += i;
        System.out.println(i);
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        t.add(5);
    }
}
