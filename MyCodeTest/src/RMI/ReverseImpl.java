package RMI;

import java.rmi.RemoteException;

/**
 * @autor mvl on 20.07.2017.
 */
public class ReverseImpl implements Reverse {
    @Override
    public String reverse(String str) throws RemoteException {
        return new StringBuffer(str).reverse().toString();
    }
}
