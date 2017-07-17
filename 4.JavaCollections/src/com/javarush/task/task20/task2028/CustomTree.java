package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }


    @Override
    public boolean add(Object o) {
        String s = (String) o;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        Entry<String> addEntry = new Entry<>(s);

        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.poll();
            currentEntry.checkChildren();
            if (currentEntry.isAvailableToAddChildren()) {
                if (currentEntry.availableToAddLeftChildren){
                    currentEntry.leftChild = addEntry;
                    currentEntry.leftChild.parent = currentEntry;
                    return true;
                } else if (currentEntry.availableToAddRightChildren) {
                    currentEntry.rightChild = addEntry;
                    currentEntry.rightChild.parent = currentEntry;
                    return true;
                }
            } else {
                if (currentEntry.leftChild != null){
                    queue.offer(currentEntry.leftChild);
                }
                if (currentEntry.rightChild != null){
                    queue.offer(currentEntry.rightChild);
                }
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.poll();
            if (currentEntry.leftChild != null) {
                if (currentEntry.leftChild.elementName.equals(s)){
                    currentEntry.leftChild = null;
                    return true;
                }
                queue.offer(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null) {
                if (currentEntry.rightChild.elementName.equals(s)){
                    currentEntry.rightChild = null;
                    return true;
                }
                queue.offer(currentEntry.rightChild);
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = -1;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.poll();
            size++;
            if (currentEntry.leftChild != null) {
                queue.offer(currentEntry.leftChild);
            }
            if (currentEntry.rightChild != null) {
                queue.offer(currentEntry.rightChild);
            }
        }
        return size;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.poll();
            if (currentEntry.elementName.equals(s)){
                return currentEntry.parent.elementName;
            } else {
                if (currentEntry.leftChild != null) {
                    queue.offer(currentEntry.leftChild);
                }
                if (currentEntry.rightChild != null) {
                    queue.offer(currentEntry.rightChild);
                }
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
