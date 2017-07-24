package XML.lect07.deserialization;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "cat")
@XmlRootElement
public class Cat {
    public String name;
    public int age, weight;

    public Cat() {
    }
}
