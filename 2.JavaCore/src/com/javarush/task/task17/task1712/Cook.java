package com.javarush.task.task17.task1712;

/**
 * Реализует действия Повара
 * Исполняется в потоке
 */

public class Cook implements Runnable {
    public boolean continueWorking = true;

    /**
     * Если очередь заказов пуста
     * через каждые 0,1 сек выводим сообщение
     * Как только заказ появляется в очереди
     * готовим блюдо
     */
    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        //готовим блюдо
                        cooking();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cooking() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();
        // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());
        // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());
        //  это готовое блюдо
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));

        //!!!!
        // добавляем в готовый заказ
        manager.getDishesQueue().add(dishes);
    }
}
