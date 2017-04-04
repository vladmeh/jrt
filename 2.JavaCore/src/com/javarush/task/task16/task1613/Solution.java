package com.javarush.task.task16.task1613;

/* 
Big Ben clock

1. Разберись, что делает программа.
2. Реализуй логику метода printTime так, чтобы каждую секунду выдавалось время начиная с установленного в конструкторе

Пример:
В г. Лондон сейчас 23:59:58!
В г. Лондон сейчас 23:59:59!
В г. Лондон сейчас полночь!
В г. Лондон сейчас 0:0:1!


Требования:
1. Метод printTime должен работать примерно секунду.
2. Метод printTime должен увеличивать (инкрементировать) количество секунд, хранимое в переменной seconds.
3. Секунд, после икрементирования времени, не может быть больше 59. Должно увеличиться количество минут.
4. Минут, после икрементирования времени, не может быть больше 59. Должно увеличиться количество часов.
5. Часов, после икрементирования времени, не может быть больше 23.
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            //Делаем задержку в секунду
            Thread.sleep(1000);
            //Проверяем секунды - не больше 59
            if (seconds < 59){
                seconds++;
            }
            else {
                seconds = 0;
                //Секунд 0
                //Проверяем минуты - не больше 59
                if (minutes < 59){
                    minutes++;
                }
                else{
                    minutes = 0;
                    //Минут 0
                    //Проверяем часы - не больше 23
                    if (hours < 23)
                        hours++;
                    else
                        hours = 0;
                        //и т.д.
                }

            }





            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}
