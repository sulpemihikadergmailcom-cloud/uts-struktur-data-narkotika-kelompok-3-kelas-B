package com.kelompok.narkotika;

import com.kelompok.narkotika.structure.DynamicArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void testAddAndGet() {
        DynamicArray<String> array = new DynamicArray<>();

        array.add("Putusan 1");
        array.add("Putusan 2");

        assertEquals(2, array.size());
        assertEquals("Putusan 1", array.get(0));
        assertEquals("Putusan 2", array.get(1));
    }

    @Test
    void testInsert() {
        DynamicArray<String> array = new DynamicArray<>();

        array.add("Putusan 1");
        array.add("Putusan 3");
        array.insert(1, "Putusan 2");

        assertEquals("Putusan 2", array.get(1));
        assertEquals(3, array.size());
    }

    @Test
    void testRemove() {
        DynamicArray<String> array = new DynamicArray<>();

        array.add("Putusan 1");
        array.add("Putusan 2");

        array.remove(0);

        assertEquals(1, array.size());
        assertEquals("Putusan 2", array.get(0));
    }
    @Test
    void testContains() {
        DynamicArray<String> array = new DynamicArray<>();

        array.add("Putusan 1");
        array.add("Putusan 2");

        assertTrue(array.contains("Putusan 1"));
        assertFalse(array.contains("Putusan 3"));
    }


    @Test
    void testClear() {
        DynamicArray<String> array = new DynamicArray<>();

        array.add("Putusan 1");
        array.clear();

        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
    }

    // TEST TAMBAHAN DARI DEBY

    @Test
    void testValidateInvariant() {
        DynamicArray<Integer> array = new DynamicArray<>();

        assertTrue(array.validateInvariant());

        array.add(10);
        array.add(20);
        array.add(30);

        assertTrue(array.validateInvariant());

        array.remove(1);

        assertTrue(array.validateInvariant());

        array.clear();

        assertTrue(array.validateInvariant());
    }
}
