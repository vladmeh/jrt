package XML.lect09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringReader;
import java.util.List;

/**
 * @autor mvl on 24.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws JAXBException
    {
        String xmldata = "<zoo><cat/><cat/><dog/><cat/></zoo>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Zoo.class, Cat.class, Dog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Zoo zoo = (Zoo) unmarshaller.unmarshal(reader);
        System.out.println(zoo);
    }


    @XmlType(name = "zoo")
    @XmlRootElement
    public static class Zoo
    {
        @XmlAnyElement
        public List<Object> animals;

        @Override
        public String toString() {
            for (Object object: animals)
                System.out.println(object.getClass().getName());
            return null;
        }
    }

    @XmlType(name = "cat")
    //@XmlRootElement
    public static class Cat
    {
        public String name;
        public int age;
        public int weight;

        public Cat() {
        }

    }

    @XmlType(name = "dog")
    //@XmlRootElement
    public static class Dog
    {
        public String name;
        public int age;
        public int weight;

        public Dog() {
        }
    }
}
