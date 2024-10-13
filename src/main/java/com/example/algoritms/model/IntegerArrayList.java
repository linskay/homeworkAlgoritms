package com.example.algoritms.model;

import java.util.Arrays;
import java.util.Random;

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
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный индекс");
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
            throw new IndexOutOfBoundsException("Некорректный индекс");
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
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный индекс");
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
            throw new com.example.algoritms.exceotion.IndexOutOfBoundsException("Некорректный индекс");
        }
        return array[index];
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof IntegerList)) {
            throw new com.example.algoritms.exceotion.IllegalArgumentException("Некорректный параметр");
        }
        IntegerList otherList = (IntegerList) other;
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

    private static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        Integer pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                Integer temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Integer temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public void sort() {
        quickSort(array, 0, size - 1);
    }

    private int binarySearch(Integer[] arr, int target) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        return binarySearch(array, item) != -1;
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }

    private static void compareSorts(Integer[] arr) {
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        long start = System.currentTimeMillis();
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Быстрая сортировка: " + (System.currentTimeMillis() - start) + " мс");
    }
}
