package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан

1.Разберись, что делает программа. Официант почему-то не относит приготовленные блюда назад к столам :(

2.Исправь ошибку.

Подсказка: это одна строчка


Требования:
1. Класс Restaurant должен содержать список поваров и официантов (public static поле threads типа List).
2. Класс Manager должен содержать очередь с заказами (private final поле orderQueue типа Queue).
3. Класс Manager должен содержать очередь с готовыми блюдами (private final поле dishesQueue типа Queue).
4. Класс Manager должен реализовывать паттерн Singleton.
5. Класс Waiter должен реализовывать интерфейс Runnable.
6. Класс Cook должен реализовывать интерфейс Runnable.
7. Если нет готовых блюд в очереди, нить класса Waiter должна получать заказ от столика и добавлять его в очередь заказов.
8. Если есть готовые блюда в очереди, нить класса Waiter должна брать блюдо из очереди и относить заказ для столика.
9. Если нет заказов в очереди с заказами, нить класса Cook должна отдыхать (повар отдыхает).
10. Если есть заказы в очереди с заказами, нить класса Cook должна готовить блюдо и добавлять его в очередь с готовыми блюдами.

Ошибка в логике
1. Нет готовых заказов в очереди, список Queue<Dishes> dishesQueue -> Manager пустой
2. Повар (нить класса Cook) не добаляет готовые блюда в очередь готовых заказов

Решение
1. Готовить блюда и добавлять их в список готовых заказов должен Повар.
2. См class Cook
3. Находим метод где повар берет заказ из списка заказов, готовит блюдо.
4. Добавляем готовое блюдо в очередь с готовыми блюдами (Queue<Dishes> dishesQueue -> Manager)

*/

public class Restaurant {
    //создаем статический список нитей (потоков)
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //Создаем нить (поток) официанта (waiter)
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        //добавляем в писок нитей (потоков)
        threads.add(waiter);

        //Создаем нить (поток) повара (cook)
        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        //добавляем в список нитей (потоков)
        threads.add(cook);

        //Запускаем нити (потоки)
        waiter.start();
        cook.start();

        //Ждем 2 сек
        Thread.sleep(2000);
        //останавливаем поток повара
        cookTarget.continueWorking = false;
        //ждем пол сек
        Thread.sleep(500);
        //останавливаем поток официанта
        waiterTarget.continueWorking = false;
    }
}
