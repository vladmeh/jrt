package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @autor mvl on 01.06.2017.
 */
public class SortLengthString {
    public static void main(String[] args) {
        String[] frends = {"Peter", "Paul", "Mariel"};
        System.out.println(Arrays.toString(frends));

        //обычная сортировка по алфавиту
        Arrays.sort(frends);
        System.out.println(Arrays.toString(frends));

        //Сортировка по длине строки
        //с помощью переопределения метода compare (в обратном порядке, сначала длинные)
        Arrays.sort(frends, new LengthComparator());
        System.out.println(Arrays.toString(frends));

        //тоже самое, с помощью лямбда
        //(o1, o2) -> o1.length()-o2.length()
        Arrays.sort(frends,Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(frends));

        Arrays.sort(frends,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(frends));
    }
}

//Чтобы сравнить символьные строки по длине, достаточно определить класс
//реализующий интерфейс Comparator<String>
class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}
