package com.javarush.task.level19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Использование метода transferToO для соединения каналов.
 * {Параметры TransferTo java TransferTo txt}
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // или:
        // out.transferFrom(in, 0, in.size());
    }
}
