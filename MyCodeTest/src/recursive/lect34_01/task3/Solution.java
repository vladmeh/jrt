package recursive.lect34_01.task3;

/**
 * @autor mvl on 26.07.2017.
 */
public class Solution {
    public static void main(String[] args)
    {
        print(3);
    }

    public static void print(int x)
    {
        if (x <=0)
            System.out.println("Boom!");
        else
        {
            System.out.println(x);
            print(x - 1);
            System.out.println(x);
        }
    }
}
