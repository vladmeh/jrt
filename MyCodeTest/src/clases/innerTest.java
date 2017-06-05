package clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 02.06.2017.
 */
public class innerTest {

    public static void main(String[] args) {

        Car car = new Car();
        System.out.println(car.getClass());
        ArrayList list = car.createPoliceCars(10);
        for (Object c: list)
            System.out.println(c);
    }
}

class Car
{
    public ArrayList createPoliceCars(int count)
    {
        ArrayList result = new ArrayList();

        for(int i=0; i<count; i++)
        {
            final int number = i;
            result.add(new Car()
            {
                public String toString()
                {
                    return ""+number;
                }
            });
        }
        return result;
    }
}