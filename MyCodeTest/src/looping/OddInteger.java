package looping;

/**
 * @autor mvl on 16.06.2017.
 */
public class OddInteger {
    public static void main(String[] args) {
        for (int i=0;i<10;i++)
        {
            if (i%2==0)
                continue;
            System.out.println(i);
        }
    }
}
