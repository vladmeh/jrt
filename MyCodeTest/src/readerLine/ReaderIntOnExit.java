package readerLine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @autor mvl on 15.06.2017.
 * считываем числа с клавиатуры
 * выводим число на экран
 * подсчитываем сумму введенных чисел
 * если введено -1 выводим на экран сумму и выходим
 */
public class ReaderIntOnExit {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true){
            int n = Integer.parseInt(reader.readLine());
            sum += n;
            if (n == -1){
                System.out.println(sum);
                break;
            }
        }

        reader.close();
    }
}
