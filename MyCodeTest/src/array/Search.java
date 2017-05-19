package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Поиск в массиве одинаковых значений
 */
public class Search {
    public static void main(String[] args) {
        //есть массив
        int[] arr = new int[100];
        //заполненный случайными числами
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(arr.length+1);
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("*********************");

        duplicate(arr);

        System.out.println(contains(arr, 10));

    }


    /**
     * Выводит на консоль повторяющиеся значения в массиве
     * @param arr
     */
    private static void duplicate(int[] arr){
        //Список результата
        List<Integer> result = new ArrayList<>();

        //последнее значение в массиве проверять нет смысла
        for (int i = 0; i < arr.length-1; i++) {
            int n = arr[i];
            //начинаем сравнивать со второго элемента массива
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == n && j != i){
                    if (!result.contains(n)){
                        result.add(n);
                        System.out.printf("%d ", n);
                    }
                }
            }

        }
    }

    /**
     * Проверяет наличия элемента в массиве
     *
     * @param arr
     * @param number
     * @return boolean
     */
    private static boolean contains(int[] arr, int number){
        for (int anArr : arr) {
            if (anArr == number) return true;
        }
        return false;
    }
}
