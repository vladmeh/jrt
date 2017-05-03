package com.javarush.task.task19.task1928;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* 
Исправить ошибку. Классы и интерфейсы

Программа содержит всего 1 логическую ошибку.
Найди и исправь ее.


Требования:
1. Класс Solution должен содержать интерфейс Example.
2. Класс Solution должен содержать класс A который реализует интерфейс Example.
3. Класс Solution должен содержать класс B который реализует интерфейс Example.
4. Класс Solution должен содержать класс C который наследуется от класса A.
5. Исправь всего одну логическую ошибку.
*/

public class Solution {
    {
        System.out.println("it's Solution class");
    }

    public static void main(String... args) throws IOException {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = Solution.class.getClassLoader().getResourceAsStream(args[1]);
        ) {
            ;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            //Неверная логика проверки типа объекта - if (result instanceof A){...}
            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("it's A class");
        }
    }

    class B implements Example {
        {
            System.out.println("it's B class");
        }
    }

    class C extends A {
        {
            System.out.println("it's C class");
        }
    }
}
