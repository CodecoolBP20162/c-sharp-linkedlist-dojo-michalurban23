package com.codecool.michalurban.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private LinkedList list;

    @BeforeEach
    void setup() {

        list = new DoublyLinkedList();
    }

    private void fillWithData() {

        list.add("Ala");
        list.add("ma");
        list.add("kota.");
        list.add("Zuzia");
        list.add("ma");
        list.add("psa.");
    }

    @Test
    void testConstructor() {

        assertNotNull(list);
    }

    @Test
    void testCountingSize() {

        fillWithData();
        int initialSize = 6;

        assertEquals(initialSize, list.size());
    }

    @Test
    void testAddingToListIncreasesSize() {

        fillWithData();
        int size = list.size();

        list.add("element");

        assertEquals(size + 1, list.size());
    }

    @Test
    void testHeadPointsToFirstNodeAdded() {

        fillWithData();

        assertEquals("Ala", list.getHead().getData());
    }

    @Test
    void testLastPointsToLastNodeAdded() {

        fillWithData();

        assertEquals("psa.", list.getLast().getData());
    }

    @Test
    void testGetsData() {

        fillWithData();

        String third = "kota.";

        assertEquals(third, list.get(2));
    }

    @Test
    void testGetThrowsExceptionWhenIndexOverSize() {

        fillWithData();

        int tooLargeIndex = 11;

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(tooLargeIndex));
    }

    @Test
    void testGetThrowsExceptionWhenIndexNegative() {

        fillWithData();

        int negativeIndex = -1;

        assertThrows(IllegalArgumentException.class, () -> list.get(negativeIndex));
    }

    @Test
    void testRemovesByIndex() {

        fillWithData();

        int index = 3;
        int sizeAfterRemoval = 5;
        list.remove(index);

        assertAll(() -> assertEquals(sizeAfterRemoval, list.size()),
                () -> assertEquals("ma", list.get(index)));
    }

    @Test
    void testRemoveThrowsExceptionWhenIndexOverSize() {

        fillWithData();

        int tooLargeIndex = 11;

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(tooLargeIndex));
    }

    @Test
    void testRemoveThrowsExceptionWhenIndexNegative() {

        fillWithData();

        int negativeIndex = -1;

        assertThrows(IllegalArgumentException.class, () -> list.remove(negativeIndex));
    }

    @Test
    void testInsertsData() {

        fillWithData();

        int index = 3;
        int expectedSize = list.size() + 1;
        Object previous = list.get(index);
        Object newObject = "some word";
        list.insert(index, newObject);

        assertAll(() -> assertEquals(newObject, list.get(index)),
                () -> assertEquals(previous, list.get(index + 1)),
                () -> assertEquals(expectedSize, list.size()));
    }

    @Test
    void testInsertThrowsExceptionWhenIndexOverSize() {

        fillWithData();

        int tooLargeIndex = 11;

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(tooLargeIndex, new Object()));
    }

    @Test
    void testInsertThrowsExceptionWhenIndexNegative() {

        fillWithData();

        int negativeIndex = -1;

        assertThrows(IllegalArgumentException.class, () -> list.insert(negativeIndex, new Object()));
    }
}