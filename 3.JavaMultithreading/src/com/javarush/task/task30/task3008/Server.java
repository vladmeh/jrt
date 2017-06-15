package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @autor mvl on 15.06.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args){

        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();

        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (IOException e){
            ConsoleHelper.writeMessage(e.getMessage());
        }

    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (String client: connectionMap.keySet()){
            try {
                connectionMap.get(client).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка! Не могу отправить сообщение клиенту : " + client);
            }
        }
    }
}
