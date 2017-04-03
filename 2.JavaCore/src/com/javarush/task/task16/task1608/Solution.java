package com.javarush.task.task16.task1608;

/* 
Продвижение на политических дебатах

1. Разберись, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал, пока не завершится всё свободное время.


Требования:
1. Вызови метод join у нужного объекта.
2. Метод toString класса политик Politician должен выводить сколько речей сказал политик, например: "Иванов сказал речь 35 раз".
3. Программа должна создавать 3 объекта типа Politician.
4. Методы, которые отвечают за вывод в консоль, не изменять.
5. Вывод программы должен свидетельствовать о том, что Иванов сказал больше всего речей на политических дебатах.
*/

public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        //т.к поток (нить) стартует сразу после инициализации,
        // метод join() нужно вызвать пока не стартовали другие потоки (нити)
        ivanov.join();
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");


        while (ivanov.getCountSpeeches() + petrov.getCountSpeeches() + sidorov.getCountSpeeches() < totalCountSpeeches) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);

    }

    public static class Politician extends Thread {
        private volatile int countSounds;

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSpeeches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeeches());
        }
    }
}

