package proxy;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @autor mvl on 19.07.2017.
 */
public class Solution {

}

class CustomInvocationHandler implements InvocationHandler
{
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("yes!");
        return null;
    }
}
