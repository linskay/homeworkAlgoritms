package com.example.algoritms.model;

import java.util.Arrays;

public class IntegerArrayList implements IntegerList {
    private Integer[] array;
    private int size;

    public IntegerArrayList() {
        array = new Integer[10];
        size = 0;
    }

    @Override
    public Integer add(Integer item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new com.example.algoritms.exception.IndexOutOfBoundsException("Некорректный индекс");
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
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exception.IndexOutOfBoundsException("Некорректный индекс");
        }
        Integer oldValue = array[index];
        array[index] = item;
        return oldValue;
    }

    @Override
    public Integer remove(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return item;
            }
        }
        return null;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exception.IndexOutOfBoundsException("Некорректный индекс");
        }
        Integer removedItem = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedItem;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new com.example.algoritms.exception.IndexOutOfBoundsException("Некорректный индекс");
        }
        return array[index];
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof IntegerList otherList)) {
            throw new com.example.algoritms.exception.IllegalArgumentException("Некорректный параметр");
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
        array = new Integer[10];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        if (array.length > size) {
            return Arrays.copyOf(array, size);
        } else {
            return array;
        }
    }

    public void sort() {
        quickSort(array, 0, size - 1);
    }

    private static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
