package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 24.07.2017.
 */

@XmlType(name="shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods {
        @XmlElementWrapper(name="goods", nillable = true)
        List<String> names = new ArrayList<>();
    }

}
