package com.javarush.task.task18.tests;

/**
 * Wrapper (Decorator) design pattern.
 */
public class WrapperDemo {
    public static void main(String... aArgs){
        TransformText transformer = new BaseWrapper(new Echo());
        show(transformer.render("blah.")); // 'blah.'

        transformer = new Capitalize(new Echo());
        show(transformer.render("blah.")); // 'BLAH.'

        transformer = new RemovePeriods(new Capitalize(new Echo()));
        show(transformer.render("blah.")); // 'BLAH'

        transformer = new RemovePeriods(new Echo());
        show(transformer.render("blah.")); // 'blah'
    }

    private static void show(String aText){
        System.out.println(aText);
    }

    private static final class Echo implements TransformText{
        public String render(String aText) {
            return aText;
        }
    }

    /**
     This class both implements the interface AND is constructed
     with an implementation of the same interface.

     Этот класс реализует интерфейс
     И построен c реализацией того же интерфейса.
     */
    private static class BaseWrapper implements TransformText {
        private TransformText fShowText;
        BaseWrapper(TransformText aTransformText){
            fShowText = aTransformText;
        }
        /**
         * Template method, calls 'before' and 'after' methods.
         * Метод шаблона, методы «до» и «после».
         */
        public final String render(String aText) {
            String text = before(aText);
            text = fShowText.render(text); //call-forward
            return after(text);
        }
        /**
         * This default implementation does nothing.
         * Эта реализация по умолчанию ничего не делает.
         */
        String before(String aText){
            return aText;
        }
        /**
         * This default implementation does nothing.
         * Эта реализация по умолчанию ничего не делает.
         */
        String after(String aText){
            return aText;
        }

    }

    private static final class Capitalize extends BaseWrapper {
        Capitalize(TransformText aTransformText){
            super(aTransformText);
        }
        @Override String before(String aText) {
            String result = aText;
            if (aText != null){
                result = result.toUpperCase();
            }
            return result;
        }
    }

    private static final class RemovePeriods extends BaseWrapper {
        RemovePeriods(TransformText aTransformText){
            super(aTransformText);
        }
        @Override String after(String aText) {
            String result = aText;
            if (aText != null){
                result = result.replace(".", "");
            }
            return result;
        }
    }
}
