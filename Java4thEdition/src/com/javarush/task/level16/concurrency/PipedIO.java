package com.javarush.task.level16.concurrency;
/**
 * Использование каналов для ввода/вывода между потоками
 *
 * В классе Sender создается канал PipedWriter, существующий как автономный объект,
 * однако при создании канала PipedReader в классе Receiver конструктору необходимо
 * передать ссылку на PipedWriter. Sender записывает данные в канал Writer и
 * бездействует в течение случайно выбранного промежутка времени.
 *
 * Класс Receiver не содержит вызовов sleep() или wait(), но при проведении чтения
 * методом read() он автоматически блокируется при отсутствии данных.
 *
 * Потоки sender и receiver запускаются из main() после того, как объекты были
 * полностью сконструированы. Если запускать не полностью сконструированные объекты,
 * каналы на различных платформах могут демонстрировать несогласованное поведение.
 */

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        try{
            for (char c = 'A'; c <= 'z' ; c++) {
                out.write(c);
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
            }
        } catch(IOException e) {
            print(e + " Sender write exception");
        } catch(InterruptedException e) {
            print(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getOut());
    }
    public void run() {
        try {
            while(true) {
                // Блокируется до появления следующего символа:
                printnb("Read: " + (char)in.read() + ", ");
            }
        } catch(IOException e) {
            print(e + " Receiver read exception");
        }
    }
}
