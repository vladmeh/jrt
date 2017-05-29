package array;

import java.util.Arrays;

/**
 * Created by mvl on 29.05.2017.
 */
public class SortingArrayInt {
    public static void main(String[] args) {
        int[] arr = new int[]{43,6,12,87,0,34,3,1,1,1,564,456,4,3,6,5,14,64};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
