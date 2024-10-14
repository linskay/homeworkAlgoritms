package com.example.algoritms.model;

public interface IntegerList {

    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
