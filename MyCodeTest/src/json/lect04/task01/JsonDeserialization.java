package json.lect04.task01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 21.07.2017.
 */
public class JsonDeserialization {
    public static void main(String[] args) throws IOException
    {
        String jsonString = "{ \"name\":\"Murka\", \"cats\": []}";
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(reader, Cat.class);

        System.out.println(cat.toString());
    }
}
