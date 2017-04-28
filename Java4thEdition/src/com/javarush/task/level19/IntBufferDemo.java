package com.javarush.task.level19;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Работа с целыми числами в буфере ByteBuffer
 * посредством буфера IntBuffer
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        // Хранить массив int:
        ib.put(new int[]{ 11, 42, 47, 99, 143, 811, 1016 });

        // Абсолютное место чтения и записи:
        System.out.println(ib.get(3));
        ib.put(3, 1811);

        // Установка нового предела перед перемоткой буфера.
        ib.flip();
        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
