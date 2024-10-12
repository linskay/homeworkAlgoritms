package com.example.algoritms.model;

import java.util.Arrays;

public class StringArrayList implements StringList {
    private String[] array;
    private int size;

    public StringArrayList() {
        array = new String[10];
        size = 0;
    }

    @Override
    public String add(String item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный параметр");
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный параметр");
        }

        String oldValue = array[index];
        array[index] = item;
        return oldValue + " заменен";
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return item;
            }
        }
        throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный параметр");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный параметр");
        }
        String removedItem = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный параметр");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new com.example.algoritms.exceotion.IllegalArgumentException("Передан null");
        }
        if (this.size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
