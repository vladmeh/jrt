package JavaBasics;

import java.util.Formatter;
import java.util.Locale;

/**
     Formatter - форматирующий класс в Java. Результатом выполнения строки 1 будет 3.33E+01, т.к. ".2"
     округляет выражение до 2-го знака после запятой, а Е преобразует выражение в инженерный вид.
     Результатом выполнения строки 2 будет 33.33, здесь также выполняется округление
     до 2-го знака после запятой.
     Без явного указания Locale мы бы получили результат в соответствии с тем,
     какой разделитель дробной и целой части установлен в системе.
     Так, например, в русской версии Windows мы бы получили 33,33.
 */
public class Test16 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.ROOT);
        formatter.format("%.2E\n", 100.0/3.0);      //1
        formatter.format("%.2f", 100.0/3.0);        //2
        System.out.println(formatter);
    }
}
