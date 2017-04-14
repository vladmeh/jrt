package com.javarush.task.task17.task1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        //Пока поток не остановлен или есть готовый заказ в очереди
        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            //если есть готовый заказ в очереди
            //список Queue<Dishes> dishesQueue -> Manager не пустой
            if (!manager.getDishesQueue().isEmpty()) {
                //относим готовый заказ
                //убираем из списка готовых заказов (Queue<Dishes> dishesQueue -> Manager)
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {
                //берем новый заказ
                //подходит к очередному столу
                Table table = manager.getNextTable();
                //создает новый заказ
                Order order = table.getOrder();
                //присваиваем заказу номер и выводим в конссоль
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                //добавляем в очередь с заказами
                //добавляем в список Queue<Order> orderQueue -> Manager
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
