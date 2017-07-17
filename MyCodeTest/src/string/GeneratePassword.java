package string;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * @autor mvl on 17.07.2017.
 */
public class GeneratePassword {
    public static void main(String[] args) {
        ByteArrayOutputStream password = generatePassword(8,10);
        System.out.println(password);
    }

    public static ByteArrayOutputStream generatePassword(int from, int to){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();

        int cntChars = from + random.nextInt(to - from + 1);

        for (int i = 0; i < cntChars; ++i) {
            char next = 0;
            int range = 10;

            switch (random.nextInt(3)) {
                case 0:
                    next = 48;
                    range = 10;
                    break;
                case 1:
                    next = 65;
                    range = 26;
                    break;
                case 2:
                    next = 97;
                    range = 26;
                    break;
            }

            byteArrayOutputStream.write(next + random.nextInt(range));
        }

        return byteArrayOutputStream;
    }
}
