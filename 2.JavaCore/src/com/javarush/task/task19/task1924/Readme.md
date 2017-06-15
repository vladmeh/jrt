taskKey="com.javarush.task.task19.task1924"

Замена чисел

1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1.	Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
2.	Программа должна считывать имя файла с консоли (используй BufferedReader).
3.	BufferedReader для считывания данных с консоли должен быть закрыт.
4.	Программа должна считывать содержимое файла (используй FileReader).
5.	Поток чтения из файла (FileReader) должен быть закрыт.
6.	Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7.	Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.

