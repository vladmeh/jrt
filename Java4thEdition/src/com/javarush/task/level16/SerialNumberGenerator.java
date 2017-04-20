package com.javarush.task.level16;

/**
 * Created by mvl on 07.04.2017.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    //если добавить к методу synchronized конфликта не будет
    public static synchronized int nextSerialNumber(){
        return serialNumber++; // Операция не является потоково-безопасной
    }
}
