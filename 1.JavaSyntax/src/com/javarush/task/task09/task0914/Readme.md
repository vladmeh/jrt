<div class="wdghtml" taskKey="com.javarush.task.task09.task0914">
<h3>Группа перехвата исключений</h3>
<p>1. Есть три исключения последовательно унаследованные от <span class="text-corporate"><strong>Exception</strong></span>:<br />
2. <span class="text-corporate"><strong>class Exception1 extends Exception</strong></span><br />
3.<span class="text-corporate"><strong> class Exception2 extends Exception1</strong></span><br />
4. <span class="text-corporate"><strong>class Exception3 extends Exception2</strong></span><br />
5. Есть <strong>метод</strong>, который описан так:<br />
<mark>public static void method1() throws Exception1, Exception2, Exception3</mark><br />
6. Напиши <mark>catch</mark>, который перехватит все три <mark>Exception1</mark>, <mark>Exception2</mark> и <mark>Exception3</mark></p>

</div>
