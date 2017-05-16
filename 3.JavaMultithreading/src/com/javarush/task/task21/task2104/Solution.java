package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode

В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.


Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    /*
    public boolean equals(Solution n) {
        if (n == this) return true;
        if (n == null || getClass() != n.getClass()) return false;
        boolean firstPart = (first != null) ? first.equals(n.first) : n.first == null;
        boolean secondPart = (last != null) ? last.equals(n.last) : n.last == null;

        return firstPart && secondPart;
    }

    @Override
    public boolean equals(Object o) {
        Solution n = (Solution) o;

        if (n == this) return true;
        if (n == null || getClass() != n.getClass()) return false;
        boolean firstPart = (first != null) ? first.equals(n.first) : n.first == null;
        boolean secondPart = (last != null) ? last.equals(n.last) : n.last == null;

        return firstPart && secondPart;
    }*/

    @Override
    public boolean equals(Object o) {
        //Рефлексивность: Объект должен равняться себе самому.
        if (this == o) return true;
        //Переданный объект должен являтся объектом класса Solution
        if (o == null || getClass() != o.getClass()) return false;

        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;

        //Симметричность: если a.equals(b) возвращает true, то b.equals(a) должен тоже вернуть true.
        //Транзитивность: если a.equals(b) возвращает true и b.equals тоже возвращает true, то c.equals тоже должен возвращать true.
        //Согласованность: повторный вызов метода equals() должен возвращать одно и тоже значение до тех пор, пока какое-либо значение свойств объекта не будет изменено.
        //Сравнение null: объект должны быть проверен на null. Если объект равен null, то метод должен вернуть false
        return (first != null ? first.equals(solution.first) : solution.first == null) && (last != null ? last.equals(solution.last) : solution.last == null);
    }

    /*
    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }
    */

    @Override
    public int hashCode() {
        int firstHashCode = (first == null) ? 0 : first.hashCode();
        int lastHashCode = (last == null) ? 0 : last.hashCode();

        return 31 * firstHashCode + lastHashCode;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
