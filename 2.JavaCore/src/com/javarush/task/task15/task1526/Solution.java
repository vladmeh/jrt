package com.javarush.task.task15.task1526;

/* 
Дебаг, дебаг, и еще раз дебаг
Программа выводит 0 9, а должна 6 9. Найди одну! ошибку и исправь.
Используй дебаг. Для этого поставь breakpoint-ы(Ctrl+F8), потом зайди в меню Run -> Debug.
F9 — выполнение кода до следующего breakpoint-а
F8 — переход к следующей строке кода
*/

public class Solution {
    public static void main(String[] args) {
        new B(6);
    }

    public static class A {
        private int f1 = 7;

        public A(int f1) {
            this.f1 = f1;
            initialize();
        }

        //Запрещаем выполнение медода дочерними классами protected -> private
        private void initialize() {
            System.out.println(f1);
        }
    }

    public static class B extends A {
        protected int f1 = 3;

        public B(int f1) {
            //breakpoint
            //Здесь вызывается конструктор БАЗВОГО класса A с переменной f1, не определена (int по умолчанию 0)
            //а так же метод initialize БАЗОВОГО класса A который и печататет 0
            //в дочернем классе метод initialize переопределен, поэтому мы можем смело закрыть метод в
            //родитеском классе
            super(f1);
            //breakpoint
            //Только после этого 6+3 = 9
            this.f1 += f1;
            //breakpoint
            initialize();
        }

        protected void initialize() {
            //breakpoint
            System.out.println(f1);
        }
    }
}
