package com.javarush.task.task17.task1720;

/**
 * Банкомат
 Разберись, как работает программа

 Во время тестирования лог содержит следующее:
 …..
 Добавляем 100, на счету 1100
 Добавляем 100, на счету 1200
 Тратим 1000, на счету 100
 Недостаточно денег
 …..

 Создан баг:
 При списании денег со счета теряются деньги

 Найти и исправить ошибку

 Требования:
 1. Класс BankAccount должен содержать private поле balance типа BigDecimal.
 2. Метод deposit(String money) класса BankAccount должен делегировать поведение в метод deposit(BigDecimal money).
 3. Метод withdraw(String money) класса BankAccount должен делегировать поведение в метод withdraw(BigDecimal money).
 4. В методе withdraw(BigDecimal money), если необходимо, используй synchronized.
 5. В методе deposit(BigDecimal money), если необходимо, используй synchronized.
 */
public class Bankomat {

    static BankAccount account = new BankAccount("Amigo");

    public static volatile boolean isStopped;

    public static void main(String[] args) throws InterruptedException {
        addMoney.start();
        SpendThread spendThread = new SpendThread();
        SpendThread spendThread1 = new SpendThread();
        SpendThread spendThread2 = new SpendThread();
        spendThread.start();
        spendThread1.start();
        spendThread2.start();
        Thread.sleep(4000);
        isStopped = true;
    }

    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) {
                account.deposit("1000");            //кладем на счет
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    };


    public static class SpendThread extends Thread {

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    account.withdraw("100");             //снимаем со счета
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Недостаточно денег");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
