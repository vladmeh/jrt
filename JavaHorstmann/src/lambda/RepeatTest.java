package lambda;

import java.util.function.IntConsumer;

/**
 * @autor mvl on 01.06.2017.
 */
public class RepeatTest {
    public static void main(String[] args) {
        repeat(10, ()-> System.out.println("Hello, World!"));
        repeatIntConsumer(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void repeatIntConsumer(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
