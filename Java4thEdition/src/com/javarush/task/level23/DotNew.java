package com.javarush.task.level23;

/**
 * Created by mvl on 29.05.2017.
 */
public class DotNew {
    public class Inner {}
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        System.out.println(dn.getClass().getCanonicalName());

        DotNew.Inner dni = dn.new Inner();
        System.out.println(dni.getClass().getCanonicalName());
    }
}
