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

        @Override
        public void run() {
            // Выводить сообщение, что установлено новое соединение с удаленным адресом
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: " +
                    socket.getRemoteSocketAddress());
            String clientName = null;

            // Создавать Connection, используя поле socket
            try(Connection connection = new Connection(socket)){

                // Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                clientName = serverHandshake(connection);

                //Рассылать всем участникам чата информацию об имени присоединившегося участника
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                //Сообщать новому участнику о существующих участниках.
                sendListOfUsers(connection, clientName);

                //Запускать главный цикл обработки сообщений сервером.
                serverMainLoop(connection, clientName);


            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error!");
            }

            // disconnecting client
            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }

            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом (%s) закрыто.", socket.getRemoteSocketAddress()));
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

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String clientName: connectionMap.keySet()){
                if (!clientName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            //Организовать бесконечный цикл
            while (true){
                // Принимать сообщение клиента
                Message message = connection.receive();

                // Если принятое сообщение – это текст
                if (message.getType() == MessageType.TEXT){
                    //  формировать новое текстовое сообщение
                    String messageText = userName + ": " + message.getData();
                    // Отправлять сформированное сообщение всем клиентам с помощью
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
                }
                else {
                    // Если принятое сообщение не является текстом, вывести сообщение об ошибке
                    ConsoleHelper.writeMessage("Error!");
                }
            }

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
