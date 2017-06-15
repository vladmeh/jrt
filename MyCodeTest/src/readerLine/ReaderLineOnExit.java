package readerLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @autor mvl on 15.06.2017.
 * Вводим строку пока не введем "exit"
 */
public class ReaderLineOnExit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = reader.readLine();
            if ("exit".equals(line))
                break;

            System.out.println(line);
        }

        reader.close();
    }
}
