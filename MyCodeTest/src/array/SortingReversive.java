package array;

import java.util.*;

/**
 * Created by mvl on 29.05.2017.
 */
public class SortingReversive {
    public static void main(String[] args) {
        List listStrings = new ArrayList(Arrays.asList("AAA","BBB","AB","bbb","A","ABC","AAa"));
        System.out.println("Исходный список: "+listStrings);
        Collections.sort(listStrings);
        System.out.println("Сортированный список в прямом порядке " + listStrings);
        Collections.sort(listStrings, Collections.reverseOrder());
        System.out.println("Сортированный список в обратном порядке"+listStrings);

    }
}
