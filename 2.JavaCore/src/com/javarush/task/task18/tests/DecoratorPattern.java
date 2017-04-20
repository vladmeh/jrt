package com.javarush.task.task18.tests;

/**
 * Decorator (Wrapper) Pattern
 */
public class DecoratorPattern {

    /**
     * класс обертка для интерфейса (расширяемого класса)
     * класс должен реализовывать интерфейс (наследоваться от класса)
     */
    public static class TransformTextWrapper implements TransformText{
        //Поле типа того интерфейса (класса) который расширяем
        private TransformText transformText;

        //Класс должен инициализировать в конструкторе поле типа того интерфейса (класса) который расширяем.
        public TransformTextWrapper(TransformText transformText) {
            this.transformText = transformText;
        }

        //Все методы должны делегировать свое выполнение объекту того интерфейса (класса) который расширяем.
        @Override
        public String render(String aInputText) {
            return transformText.render(aInputText).toUpperCase();
        }
    }

    private static final class Echo implements TransformText{
        public String render(String aText) {
            return aText;
        }
    }

    public static void main(String[] args) {
        String s = "Заголовок...";

        //Без обертки
        TransformText text = new Echo();
        System.out.println(text.render(s));

        //С оберткой (декоратором)
        TransformText transformText = new TransformTextWrapper(new Echo());
        System.out.println(transformText.render(s));
    }
}
