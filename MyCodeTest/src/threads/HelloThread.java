package threads;

/**
 * @autor mvl on 08.06.2017.
 */
public class HelloThread {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Hello " + Thread.currentThread().getName());
        task.run();

        new Thread(task).start();

        System.out.println("Done!");
    }
}
