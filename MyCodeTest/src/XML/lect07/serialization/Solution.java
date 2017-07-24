package XML.lect07.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @autor mvl on 24.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws JAXBException
    {
        //создание объектов Cat&Zoo для сериализации в XML
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat);
        zoo.animals.add(cat);

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // самосериализация
        marshaller.marshal(zoo, writer);

        //преобразовываем все записанное в StringWriter в строку
        System.out.println(writer.toString());
    }

}
