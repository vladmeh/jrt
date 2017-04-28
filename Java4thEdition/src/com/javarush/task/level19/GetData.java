package com.javarush.task.level19;

import java.nio.ByteBuffer;

import static net.mindview.util.Print.*;

/**
 * Получение различных данных из буфера ByteBuffer
 */
public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        // Распределение автоматически обнуляет ByteBuffer:
        int i = 0;
        while(i++ < bb.limit())
            if(bb.get() != 0)
                print("nonzero");
        print("i = " + i);
        bb.rewind();

        // Сохраните и прочитайте массив символов:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) != 0)
            printnb(c + " ");
        print();
        bb.rewind();

        // Хранить и читать short:
        bb.asShortBuffer().put((short)471142);
        print(bb.getShort());
        bb.rewind();

        // Хранить и читать int:
        bb.asIntBuffer().put(99471142);
        print(bb.getInt());
        bb.rewind();

        // Хранить и читать long:
        bb.asLongBuffer().put(99471142);
        print(bb.getLong());
        bb.rewind();

        // Хранить и читать float:
        bb.asFloatBuffer().put(99471142);
        print(bb.getFloat());
        bb.rewind();

        // Хранить и читать double:
        bb.asDoubleBuffer().put(99471142);
        print(bb.getDouble());
        bb.rewind();
    }
}
