package com.example.algoritms.model;

import com.example.algoritms.exception.IllegalArgumentException;
import com.example.algoritms.exception.IndexOutOfBoundsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListTest {

    @Test
    @DisplayName("Добавление элемента в пустой список")
    void addElementToEmptyList() {
        IntegerArrayList list = new IntegerArrayList();
        Integer addedItem = list.add(5);
        assertEquals(5, addedItem);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    @DisplayName("Добавление элемента в список с существующими элементами")
    void addElementToListWithExistingElements() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        Integer addedItem = list.add(3);
        assertEquals(3, addedItem);
        assertEquals(3, list.size());
        assertEquals(3, list.get(2));
    }

    @Test
    @DisplayName("Добавление элемента по индексу в пустой список")
    void addElementByIndexToEmptyList() {
        IntegerArrayList list = new IntegerArrayList();
        Integer addedItem = list.add(0, 5);
        assertEquals(5, addedItem);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    @DisplayName("Добавление элемента по индексу в список с существующими элементами")
    void addElementByIndexToListWithExistingElements() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        Integer addedItem = list.add(1, 3);
        assertEquals(3, addedItem);
        assertEquals(3, list.size());
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    @DisplayName("Добавление элемента по индексу, выходящему за границы списка")
    void addElementByIndexOutOfBounds() {
        IntegerArrayList list = new IntegerArrayList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 5));
    }

    @Test
    @DisplayName("Изменение элемента по индексу")
    void setElementByIndex() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        Integer oldValue = list.set(1, 3);
        assertEquals(2, oldValue);
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Изменение элемента по индексу, выходящему за границы списка")
    void setElementByIndexOutOfBounds() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 3));
    }

    @Test
    @DisplayName("Удаление элемента по значению")
    void removeElementByValue() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(1);
        Integer removedItem = list.remove(1);
        assertEquals(2, removedItem);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    @DisplayName("Удаление несуществующего элемента по значению")
    void removeNonExistingElementByValue() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () ->  list.remove(3));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Удаление элемента по индексу")
    void removeElementByIndex() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer removedItem = list.remove(1);
        assertEquals(2, removedItem);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    @DisplayName("Удаление элемента по индексу, выходящему за границы списка")
    void removeElementByIndexOutOfBounds() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    @DisplayName("Получение индекса элемента")
    void indexOfElement() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(1);
        int index = list.indexOf(2);
        assertEquals(1, index);
    }

    @Test
    @DisplayName("Получение индекса несуществующего элемента")
    void indexOfNonExistingElement() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        int index = list.indexOf(3);
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("Получение индекса последнего вхождения элемента")
    void lastIndexOfElement() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(1);
        int index = list.lastIndexOf(1);
        assertEquals(2, index);
    }

    @Test
    @DisplayName("Получение индекса последнего вхождения несуществующего элемента")
    void lastIndexOfNonExistingElement() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        int index = list.lastIndexOf(3);
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("Получение элемента по индексу")
    void getElementByIndex() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        Integer element = list.get(1);
        assertEquals(2, element);
    }

    @Test
    @DisplayName("Получение элемента по индексу, выходящему за границы списка")
    void getElementByIndexOutOfBounds() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    @DisplayName("Сравнение двух списков с одинаковым содержимым")
    void equalsWithSameContent() {
        IntegerArrayList list1 = new IntegerArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        IntegerArrayList list2 = new IntegerArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        assertEquals(list1, list2);
    }

    @Test
    @DisplayName("Сравнение двух списков с разным содержимым")
    void equalsWithDifferentContent() {
        IntegerArrayList list1 = new IntegerArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        IntegerArrayList list2 = new IntegerArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(4);

        assertNotEquals(list1, list2);
    }

    @Test
    @DisplayName("Сравнение списка с null")
    void equalsWithNull() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IllegalArgumentException.class, () -> list.equals(null));
    }

    @Test
    @DisplayName("Сравнение списка с объектом другого типа")
    void equalsWithDifferentType() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IllegalArgumentException.class, () -> list.equals("test"));
    }

    @Test
    @DisplayName("Проверка размера списка")
    void size() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("Проверка пустого списка")
    void isEmpty() {
        IntegerArrayList list = new IntegerArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Проверка непустого списка")
    void isNotEmpty() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Очистка списка")
    void clear() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Преобразование списка в массив")
    void toArray() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = list.toArray();
        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }

    @Test
    @DisplayName("Сортировка списка")
    void sort() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }
}