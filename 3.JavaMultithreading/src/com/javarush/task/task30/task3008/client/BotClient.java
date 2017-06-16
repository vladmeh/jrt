package com.javarush.task.task30.task3008.client;

/**
 * @autor mvl on 16.06.2017.
 */
public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread{

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        double x = Math.random()*100;

        return "date_bot_" + (int)x;
    }
}
