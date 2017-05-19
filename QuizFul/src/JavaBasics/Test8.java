package JavaBasics;

/**
 *  1: Float.valueOf(value) дает 29.1f. Далее 29.1f приводится к double т.к. 1.0 имеет тип double
 *  (по-умолчанию все литералы с плавающей точкой имеют тип double).
 *  Получаем 29.100000381469727d.
 *  Соответственно (Float.valueOf(value) + 1.0)=30.100000381469727d.
 *  И в результате (Float.valueOf(value) + 1.0) == 30.1 равно false.
 *  2: Аналогично п.1 только без приведения float к double, все переменные типа double.
 *  (Double.valueOf(value) + 1.0) дает 30.1d. И в результате (Double.valueOf(value) + 1.0) == 30.1
 *  равно true.
 *  3: Деление float на ноль не дает ArithmeticException (только деление целого типа на ноль даст
 *  ArithmeticException), для таких случаев в классе Float даже определена константа:
 *  public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
 *  Причем если заглянуть в исходники метода java.io.PrintStream#println(float), то становится
 *  ясно что float превращается в строку с помощью метода String.valueOf(float),
 *  который POSITIVE_INFINITY преобразует в "Infinity".
 *  4: Аналогично п.3.
 */
public class Test8 {
    public static void main(String[] args) {
        try {
            String value = "29.1";
            System.out.println((Float.valueOf(value) + 1.0));
            System.out.println((Float.valueOf(value) + 1.0) == 30.1);
            System.out.println((Double.valueOf(value) + 1.0));
            System.out.println((Double.valueOf(value) + 1.0) == 30.1);
            System.out.println(Float.valueOf(value)/0);
            System.out.println(Double.valueOf(value)/0);
        }
        catch (NumberFormatException ex) {
            System.out.println("NumberFormatException");
        }
        catch (ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }
    }
}
