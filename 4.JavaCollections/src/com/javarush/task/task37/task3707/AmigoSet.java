package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

/**
 * @autor mvl on 15.09.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();

        s.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        s.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

        s.writeInt(map.size());
        for(E e:map.keySet())
            s.writeObject(e);

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();

        int size = (int)s.readObject();
        Set<E> set = new HashSet<>();

        for(int i =0;i<size;i++)
            set.add((E)s.readObject());

        int capacity = s.readInt();
        float loadFactor = s.readFloat();

        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }
}
