package JavaBasics;

/**
 * Created by mvl on 19.05.2017.
 */
public class Test10 {
    public static void main(String[] args) {
        label1: for (int i = 0; i < 3; i++) {
            if (i == 1)
                continue label1;
            label2:
            System.out.print("TEST ");
            label3:;
        }
    }
}
