package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.*;

/**
 * @autor mvl on 15.06.2017.
 */
public class Connection implements Closeable{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        // Создать объект класса ObjectOutputStream нужно до того, как будет создаваться объект
        // класса ObjectInputStream, иначе может возникнуть взаимная блокировка потоков,
        // которые хотят установить соединение
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        synchronized (out){
            out.writeObject(message);
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in){
            return (Message)in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
