package com.example.algoritms.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {

    private StringArrayList arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new StringArrayList();
    }

    @Test
    @DisplayName("Добавление элемента, положительный тест")
    void testAdd() {
        assertEquals(0, arrayList.size());

        arrayList.add("Привет");
        assertEquals(1, arrayList.size());
        assertEquals("Привет", arrayList.get(0));

        arrayList.add("Мир");
        assertEquals(2, arrayList.size());
        assertEquals("Мир", arrayList.get(1));
    }

    @Test
    @DisplayName("Положительный тест на вставку")
    void testAddByIndex() {
        arrayList.add("Привет");

        arrayList.add(0, "Java");
        assertEquals(2, arrayList.size());
        assertEquals("Java", arrayList.get(0));
        assertEquals("Привет", arrayList.get(1));

        arrayList.add(1, "Мир"); // Вставка в середину
        assertEquals(3, arrayList.size());
        assertEquals("Java", arrayList.get(0));
        assertEquals("Мир", arrayList.get(1));
        assertEquals("Привет", arrayList.get(2));

        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.add(4, "Test"));
    }

    @Test
    @DisplayName("Положительный тест на замену элементов")
    void testSet() {
        arrayList.add("Привет");
        arrayList.add("Мир");

        assertEquals("Мир заменен", arrayList.set(1, "Java"));
        assertEquals(2, arrayList.size());
        assertEquals("Привет", arrayList.get(0));
        assertEquals("Java", arrayList.get(1));

        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.set(3, "Test"));
    }

    @Test
    @DisplayName("Положительный тест на удаление, выбрасывание исключения")
    void testRemoveByItem() {
   arrayList.add("Привет");
      arrayList.add("Мир");
      arrayList.add("Привет");

        assertEquals("Мир", arrayList.remove("Мир"));
        assertEquals(2, arrayList.size());
        assertEquals("Привет", arrayList.get(0));
        assertEquals("Привет", arrayList.get(1));

        assertEquals("Привет", arrayList.remove("Привет"));
        assertEquals(1, arrayList.size());
        assertEquals("Привет", arrayList.get(0));

        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.remove("Java"));
    }

    @Test
    @DisplayName("Положительный тест на удаление, выбрасывание исключения по индексу")
    void testRemoveByIndex() {
        arrayList.add("Привет");
        arrayList.add("Мир");

        assertEquals("Мир", arrayList.remove(1));
        assertEquals(1, arrayList.size());
        assertEquals("Привет", arrayList.get(0));

        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.remove(2));
    }

    @Test
    @DisplayName("Положительный тест на возвращение индекса и -1")
    void testIndexOf() {
       arrayList.add("Привет");
        arrayList.add("Мир");
        arrayList.add("Привет");

        assertEquals(0, arrayList.indexOf("Привет"));
        assertEquals(2, arrayList.lastIndexOf("Привет"));
        assertEquals(1, arrayList.indexOf("Мир"));
        assertEquals(-1, arrayList.indexOf("Java"));
    }

    @Test
    @DisplayName("Положительный тест на возвращение индекса с конца и -1")
    void testLastIndexOf() {
        arrayList.add("Привет");
        arrayList.add("Мир");
        arrayList.add("Привет");

        assertEquals(2, arrayList.lastIndexOf("Привет"));
        assertEquals(1, arrayList.lastIndexOf("Мир"));
        assertEquals(-1, arrayList.lastIndexOf("Java"));
    }

    @Test
    @DisplayName("Успешная проверка на существующий элемент")
    void testContains() {
        arrayList.add("Привет");
        arrayList.add("Мир");

        assertTrue(arrayList.contains("Привет"));
        assertTrue(arrayList.contains("Мир"));
        assertFalse(arrayList.contains("Java"));
    }

    @Test
    @DisplayName("Успешная проверка получение размера массива")
    void testSize() {
        assertEquals(0, arrayList.size());

        arrayList.add("Привет");
        assertEquals(1, arrayList.size());

        arrayList.add("Мир");
        assertEquals(2, arrayList.size());
    }

    @Test
    @DisplayName("Проверка метода, который возвращает тру когда нет элементов в списке")
    void testIsEmpty() {
        assertTrue(arrayList.isEmpty());

        arrayList.add("Привет");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    @DisplayName("Успешная проверка на очищение массива от данных")
    void testClear() {
        arrayList.add("Привет");
        arrayList.add("Мир");
        assertEquals(2, arrayList.size());

        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    @DisplayName("Успешная проверка на создание нового массива")
    void testToArray() {
        arrayList.add("Привет");
        arrayList.add("Мир");

        String[] array = arrayList.toArray();
        assertEquals(2, array.length);
        assertEquals("Привет", array[0]);
        assertEquals("Мир", array[1]);
    }

    @Test
    @DisplayName("Положительный тест на сравнивание массивов и отображение исключения")
    void testEquals() {
        arrayList.add("Привет");
        arrayList.add("Мир");
        StringArrayList arrayList2 = new StringArrayList();
        arrayList2.add("Привет");
        arrayList2.add("Мир");

        assertTrue(arrayList.equals(arrayList2));

        StringArrayList arrayList3 = new StringArrayList();
        arrayList3.add("Привет");
        arrayList3.add("Земля");

        assertFalse(arrayList.equals(arrayList3));

        assertThrows(com.example.algoritms.exceotion.IllegalArgumentException.class, () -> arrayList.equals(null));
    }

    @Test
    @DisplayName("Положительный тест на выбрасывание исключений, если массив выходит за рамки фактического")
    void testGet() {
       arrayList.add("Привет");
        arrayList.add("Мир");

        assertEquals("Привет", arrayList.get(0));
        assertEquals("Мир", arrayList.get(1));

        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.get(2));
        assertThrows(com.example.algoritms.exceotion.IndexOutOfBoundsException.class, () -> arrayList.get(-1));
    }
}
