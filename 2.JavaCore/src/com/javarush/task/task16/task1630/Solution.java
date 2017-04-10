package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    //d:\JavaRush\test1.txt
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFilename;
        //Обязательное инициализировать как = ""
        //иначе занчение по умолчанию null и на выводе "nulltest1 тест1"
        private String fileContent = "";

        @Override
        public void run() {
            try {
                //Метод run класса ReadFileThread должен считывать строки из файла
                BufferedReader br = new BufferedReader(new FileReader(fullFilename));
                //Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
                while (br.ready())
                    fileContent = fileContent + br.readLine() + " ";

            } catch (IOException e) {
                e.printStackTrace();
            }
            interrupt();
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFilename = fullFileName;
        }

        //А метод getFileContent, этого же класса, должен возвращать вычитанный контент
        @Override
        public String getFileContent() {
            return fileContent;
        }
    }
}
