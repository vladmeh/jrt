package XML.lect07.deserialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @autor mvl on 24.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws JAXBException {
        String xmldata = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Cat cat = (Cat) unmarshaller.unmarshal(reader);
        System.out.println(cat.name + ", " + cat.age + ", " + cat.weight);
    }
}


