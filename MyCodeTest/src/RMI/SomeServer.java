package RMI;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @autor mvl on 20.07.2017.
 */
public class SomeServer {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception
    {
        //создание объекта для удаленного доступа
        final ReverseImpl service = new ReverseImpl();

        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(2099);
        //создание "заглушки" – приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистрация "заглушки" в реесте
        registry.bind(UNIC_BINDING_NAME, stub);

        //усыпляем главный поток, иначе программа завершится
        Thread.sleep(Integer.MAX_VALUE);
    }
}
