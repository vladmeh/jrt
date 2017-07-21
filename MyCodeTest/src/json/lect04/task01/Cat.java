package json.lect04.task01;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 21.07.2017.
 */

@JsonAutoDetect
public class Cat {
    public String name;
    @JsonDeserialize(as=ArrayList.class)
    public List<Cat> cats = new ArrayList();

    Cat() {
    }
}
