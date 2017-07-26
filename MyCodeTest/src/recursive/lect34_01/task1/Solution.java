package recursive.lect34_01.task1;

/**
 * @autor mvl on 26.07.2017.
 */
public class Solution {
    public static void main(String[] args)
    {
        countDown(10);
    }

    public static void countDown(int x)
    {
        if (x <=0)
            System.out.println("Boom!");
        else
        {
            System.out.println(x);
            countDown(x - 1);
        }
    }
}
