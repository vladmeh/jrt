package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;

/**
 * @autor mvl on 21.07.2017.
 */
public class ConvertOutJson {
    public static void main(String[] args) throws IOException
    {
        //String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"weight\":4}";
        String jsonString = "{ \"alias\":\"Murka\", \"age\":5, \"weight\":4}";
        StringReader reader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(reader, Cat.class);

        System.out.println(cat.getName() + ", " + cat.getAge() + ", " + cat.getWeight());
    }
}
