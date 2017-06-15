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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name;

            // Если какая-то проверка не прошла, заново запросить имя клиента
            while (true){
                // Сформировать и отправить команду запроса имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));
                // Получить ответ клиента
                Message message = connection.receive();
                // Проверить, что получена команда с именем пользователя
                if (message.getType() == MessageType.USER_NAME){
                    // Достать из ответа имя
                    name = message.getData();
                    // проверить, что оно не пустое и пользователь с таким именем еще не подключен
                    if (!name.isEmpty() && !connectionMap.containsKey(name)){
                        // Добавить нового пользователя и соединение с ним в connectionMap
                        connectionMap.put(name, connection);
                        // Отправить клиенту команду информирующую, что его имя принято
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }

            // Вернуть принятое имя в качестве возвращаемого значения
            return name;
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
