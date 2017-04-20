package com.javarush.task.task18.task1811;

/* 
Wrapper (Decorator)

Разберись, что делает программа.
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl.


Требования:
1. Создай класс DecoratorMyRunnableImpl, аналогичный DecoratorRunnableImpl.
2. После запуска, каждый класс должен вывести в консоль "'Имя класса' body".
3. Классы RunnableImpl и DecoratorRunnableImpl изменять нельзя.
4. Метод main изменять нельзя.
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(
                new DecoratorMyRunnableImpl(
                        new RunnableImpl()
                )
        )).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

    private static class DecoratorMyRunnableImpl implements Runnable {
        private Runnable runnable;

        public DecoratorMyRunnableImpl(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            System.out.print("DecoratorMyRunnableImpl body ");
            runnable.run();
        }
    }
}
