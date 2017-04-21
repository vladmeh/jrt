package com.javarush.task.task18.task1818;

import java.io.*;

/**
 * Created by mvl on 21.04.2017.
 */
public class SolutionTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fos = new FileOutputStream(reader.readLine());
        FileInputStream fis1 = new FileInputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());

        byte[] bf1 = new byte[fis1.available()];
        byte[] bf2 = new byte[fis2.available()];

        fis1.read(bf1);
        fis2.read(bf2);

        fos.write(bf1);
        fos.write(bf2);

        reader.close();
        fis1.close();
        fis2.close();
        fos.close();
    }
}
