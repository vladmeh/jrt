taskKey="com.javarush.task.task32.task3203"

Пишем стек-трейс

Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String) должен возвращать весь стек-трейс переданного исключения.
Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
Метод main не участвует в тестировании.


Требования:
1.	Публичный статический метод String getStackTrace (Throwable) должен существовать.
2.	В методе getStackTrace необходимо создать объект типа StringWriter.
3.	В методе getStackTrace (Throwable) необходимо использовать метод класса Throwable, который принимает объект типа PrintWriter.
4.	Метод getStackTrace (Throwable) должен возвращать весь стек-трейс переданного исключения.

