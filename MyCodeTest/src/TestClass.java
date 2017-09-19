import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @autor mvl on 19.09.2017.
 */
public class TestClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("Toast");
        list.add("Beer");

        int count = 2;
        list.removeIf(s -> s.length() <= count); //1
        list.forEach(System.out::println);

        if (list.size() == 2) {
            //count = 5; //3
        } else {
            System.out.println("Hello!");
        }
    }
}
