package files;

import java.nio.charset.Charset;

/**
 * Created by mvl on 23.05.2017.
 */
public class CurrentCharset {
    public static void main(String[] args) {
        Charset currentCharset = Charset.defaultCharset();//узнать текущую кодировку
        System.out.println(currentCharset.toString());
    }
}
