package com.example.algoritms.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListTest {

    private IntegerArrayList integerArrayList;

    @BeforeEach
    void setUp() {
        integerArrayList = new IntegerArrayList();
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента")
    void testAddPositive() {
        integerArrayList.add(10);
        assertEquals(1, integerArrayList.size());
        assertEquals(10, integerArrayList.get(0));
    }

    @Test
    @DisplayName("Отрицательный тест на добавление элемента с выходом за пределы списка")
    void testAddNegativeIndexOutOfBounds() {
        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> integerArrayList.add(1, 10));
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента по индексу")
    void testAddByIndexPositive() {
        integerArrayList.add(10);
        integerArrayList.add(0, 5);
        assertEquals(2, integerArrayList.size());
        assertEquals(5, integerArrayList.get(0));
        assertEquals(10, integerArrayList.get(1));
    }

    @Test
    @DisplayName("Положительный тест на установку элемента")
    void testSetPositive() {
        integerArrayList.add(10);
        assertEquals(10, integerArrayList.set(0, 20));
        assertEquals(20, integerArrayList.get(0));
    }

    @Test
    @DisplayName("Отрицательный тест на установку элемента с выходом за пределы списка")
    void testSetNegativeIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> integerArrayList.set(1, 20));
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента по значению")
    void testRemoveByItemPositive() {
        integerArrayList.add(1);
        integerArrayList.add(20);
        assertEquals(20, integerArrayList.remove(1));
        assertEquals(1, integerArrayList.size());
    }

    @Test
    @DisplayName("Отрицательный тест на удаление несуществующего элемента по значению")
    void testRemoveByItemNegative() {
        integerArrayList.add(10);
        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class,() -> integerArrayList.remove(20));
        assertEquals(1, integerArrayList.size());
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента по индексу")
    void testRemoveByIndexPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        assertEquals(20, integerArrayList.remove(1));
        assertEquals(1, integerArrayList.size());
    }

    @Test
    @DisplayName("Отрицательный тест на удаление элемента по индексу с выходом за границы")
    void testRemoveByIndexNegative() {
        integerArrayList.add(10);
        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> integerArrayList.remove(2));
    }

    @Test
    @DisplayName("Положительный тест на проверку наличия элемента")
    void testContainsPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        assertTrue(integerArrayList.contains(10));
    }

    @Test
    @DisplayName("Отрицательный тест на проверку наличия несуществующего элемента")
    void testContainsNegative() {
        integerArrayList.add(10);
        assertFalse(integerArrayList.contains(30));
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса элемента")
    void testIndexOfPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        assertEquals(0, integerArrayList.indexOf(10));
    }

    @Test
    @DisplayName("Отрицательный тест на поиск несуществующего элемента")
    void testIndexOfNegative() {
        integerArrayList.add(10);
        assertEquals(-1, integerArrayList.indexOf(30));
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса последнего вхождения элемента")
    void testLastIndexOfPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(10);
        assertEquals(2, integerArrayList.lastIndexOf(10));
    }

    @Test
    @DisplayName("Отрицательный тест на поиск несуществующего элемента")
    void testLastIndexOfNegative() {
        integerArrayList.add(10);
        assertEquals(-1, integerArrayList.lastIndexOf(30));
    }

    @Test
    @DisplayName("Положительный тест на получение элемента по индексу")
    void testGetPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        assertEquals(10, integerArrayList.get(0));
    }

    @Test
    @DisplayName("Отрицательный тест на получение элемента по индексу с выходом за границы")
    void testGetNegativeIndexOutOfBounds() {
        integerArrayList.add(10);
        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class,
                () -> integerArrayList.get(2));
    }

    @Test
    @DisplayName("Положительный тест на сравнение списков")
    void testEqualsPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);

        IntegerArrayList otherList = new IntegerArrayList();
        otherList.add(10);
        otherList.add(20);

        assertTrue(integerArrayList.equals(otherList));
    }

    @Test
    @DisplayName("Отрицательный тест на сравнение списков разной длины")
    void testEqualsNegativeDifferentSize() {
        integerArrayList.add(10);

        IntegerArrayList otherList = new IntegerArrayList();
        otherList.add(10);
        otherList.add(20);

        assertFalse(integerArrayList.equals(otherList));
    }

    @Test
    @DisplayName("Отрицательный тест на сравнение списков с разными элементами")
    void testEqualsNegativeDifferentElements() {
        integerArrayList.add(10);

        IntegerArrayList otherList = new IntegerArrayList();
        otherList.add(30);

        assertFalse(integerArrayList.equals(otherList));
    }

    @Test
    @DisplayName("Отрицательный тест на сравнение с null")
    void testEqualsNegativeNull() {
        assertThrows(com.example.algoritms.exceotion.IllegalArgumentException.class,
                () -> integerArrayList.equals(null));
    }

    @Test
    @DisplayName("Положительный тест на получение размера списка")
    void testSizePositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        assertEquals(2, integerArrayList.size());
    }

    @Test
    @DisplayName(
            "Положительный тест на проверку пустого списка")
    void testIsEmptyPositive() {
        assertTrue(integerArrayList.isEmpty());
    }

    @Test
    @DisplayName("Отрицательный тест на проверку непустого списка")
    void testIsEmptyNegative() {
        integerArrayList.add(10);
        assertFalse(integerArrayList.isEmpty());
    }

    @Test
    @DisplayName("Положительный тест на очистку списка")
    void testClearPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.clear();
        assertTrue(integerArrayList.isEmpty());
    }

    @Test
    @DisplayName("Положительный тест на создание массива из элементов списка")
    void testToArrayPositive() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        Integer[] array = integerArrayList.toArray();
        assertEquals(2, array.length);
    }

    @Test
    @DisplayName("Положительный тест на сортировку списка")
    void testSortPositive() {
        integerArrayList.add(20);
        integerArrayList.add(10);
        integerArrayList.add(30);
        integerArrayList.sort();
        assertEquals(10, integerArrayList.get(0));
        assertEquals(20, integerArrayList.get(1));
        assertEquals(30, integerArrayList.get(2));
    }

    @Test
    @DisplayName("Положительный тест на время выполнения сортировки")
    void testSortPerformance() {
        Integer[] array = IntegerArrayList.generateRandomArray(100000);
        IntegerArrayList list = new IntegerArrayList();
        for (Integer item : array) {
            list.add(item);
        }
        long start = System.currentTimeMillis();
        list.sort();
        long end = System.currentTimeMillis();
        System.out.println("Время сортировки: " + (end - start) + " мс");
    }
}

