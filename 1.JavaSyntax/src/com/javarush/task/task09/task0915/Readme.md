<div class="wdghtml" taskKey="com.javarush.task.task09.task0915">
<h3>Перехват выборочных исключений</h3>
<p>1. Разберись, какие исключения бросает метод <mark>BEAN.methodThrowExceptions</mark>.<br />
2. Метод <mark>processExceptions</mark> должен вызывать метод <mark>BEAN.methodThrowExceptions</mark> и обрабатывать исключения:<br />
2.1. если возникло исключение <mark>FileSystemException</mark>, то логировать его (<em>вызвать метод </em><strong>BEAN.log</strong>) и пробросить дальше<br />
2.2. если возникло исключение <mark>CharConversionException</mark> или любое другое <mark>IOException</mark>, то только логировать его (<em>вызвать метод</em> <strong>BEAN.log</strong>)<br />
3. Добавь в объявление метода <mark>processExceptions</mark> класс исключения, которое ты пробрасываешь в <em>п.2.1.</em><br />
4. В методе <mark>main</mark> обработай оставшееся исключение &#8212; логируй его. Используй <mark>try..catch<br />
</mark></p>
<p><strong>Подсказка:</strong><br />
<em><strong>Если ты захватил исключение MyException, которое не хотел захватывать, его можно пробросить дальше кодом вида:</strong></em><br />
<code>catch (MyException e) {<br />
&nbsp;throw e;<br />
}</code></p>

</div>
