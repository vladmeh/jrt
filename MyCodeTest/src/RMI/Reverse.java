package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @autor mvl on 20.07.2017.
 */
interface Reverse extends Remote
{
    public String reverse(String str) throws RemoteException;
}