package regexp;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Трюк в том, что мы считаем точку концом предложения только если после неё есть пробел.
 * И делаем знак препинания необязательным.
 * Для того, чтобы финальная точка ловилась, дописываем ещё пробел в конец строки.
 */
public class StringToWords {
    public static void main(String[] args) {
        String s = "I like you 100 times, and you? I'm not sure about number 1.2345.";
        String[] words = (s + " ").split("\\p{P}?[ \\t\\n\\r]+");
        System.out.println(Arrays.toString(words));
    }
}
