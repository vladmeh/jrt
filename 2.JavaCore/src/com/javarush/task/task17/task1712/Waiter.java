package com.javarush.task.task17.task1712;

/**
 * Реализует действия Официанта
 * исполняется в потоке.
 */
public class Waiter implements Runnable {
    //Инстанируем класс управления Manager
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        //Пока поток не остановлен или есть готовый заказ в очереди
        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            //Если есть готовый заказ в очереди относим готовый заказ
            if (!manager.getDishesQueue().isEmpty()) {
                //Берем заказ из очереди готовых заказов
                Dishes dishes = manager.getDishesQueue().poll();
                //Выводим сообщение
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            }
            else { //берем новый заказ
                //подходит к очередному столу
                Table table = manager.getNextTable();
                //создает новый заказ
                Order order = table.getOrder();
                //Привязываем заказ к номеру столика
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                //добавляем в очередь с заказами
                manager.getOrderQueue().add(order);
            }
            try {
                //задержка в 0,1 сек
                //Идет к новому столу
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
