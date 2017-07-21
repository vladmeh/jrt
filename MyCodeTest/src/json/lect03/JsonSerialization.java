package json.lect03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonSerialization {
    public static void main(String[] args) throws IOException, IOException {
        //создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.setName("Murka");
        cat.setAge(5);
        cat.setWeight(4);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        mapper.writeValue(writer, cat);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println(result);
    }
}
