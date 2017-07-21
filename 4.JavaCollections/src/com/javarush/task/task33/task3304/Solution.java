package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //Сериализуем объект
        StringWriter writer = new StringWriter();
        //Конвертируем one в JSON
        mapper.writeValue(writer, one);
        //System.out.println(writer.toString());

        //Reflection
        //Получаем имена классов в нижнем регистре
        String oneClassName = one.getClass().getSimpleName().toLowerCase();
        String resultClassName = resultClassObject.getSimpleName().toLowerCase();
        //Меняем в строке JSON имена классов, т.е. подменяем типы объекта JSON
        String jsonStr = writer.toString().replaceFirst(oneClassName, resultClassName);

        //Десериализуем объект
        StringReader reader = new StringReader(jsonStr);
        //Конвертируем JSON в resultClassObject
        Object result = mapper.readValue(reader, resultClassObject);

        return result;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
