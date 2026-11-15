package com.kelompok.narkotika;

import com.kelompok.narkotika.structure.CustomStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomStackTest {

    @Test
    void testPushAndPeek() {
        CustomStack<String> stack = new CustomStack<>();

        stack.push("Tambah");
        stack.push("Hapus");

        assertEquals("Hapus", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testPop() {
        CustomStack<String> stack = new CustomStack<>();

        stack.push("Tambah");
        stack.push("Hapus");

        assertEquals("Hapus", stack.pop());
        assertEquals("Tambah", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void testIsEmpty() {
        CustomStack<String> stack = new CustomStack<>();

        assertTrue(stack.isEmpty());

        stack.push("Tambah");

        assertFalse(stack.isEmpty());
    }

    @Test
    void testClear() {
        CustomStack<String> stack = new CustomStack<>();

        stack.push("Tambah");
        stack.push("Hapus");

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testPopFromEmptyStack() {
        CustomStack<String> stack = new CustomStack<>();

        assertThrows(
                IllegalStateException.class,
                stack::pop
        );
    }

    @Test
    void testPeekFromEmptyStack() {
        CustomStack<String> stack = new CustomStack<>();

        assertThrows(
                IllegalStateException.class,
                stack::peek
        );
    }

    // TEST TAMBAHAN DARI DEBY

    @Test
    void testValidateInvariant() {
        CustomStack<String> stack = new CustomStack<>();

        assertTrue(stack.validateInvariant());

        stack.push("A");
        stack.push("B");

        assertTrue(stack.validateInvariant());

        stack.pop();

        assertTrue(stack.validateInvariant());
    }

    @Test
    void testSearchPreserveFound() {
        CustomStack<String> stack = new CustomStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertTrue(stack.searchPreserve("B"));

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    void testSearchPreserveNotFound() {
        CustomStack<String> stack = new CustomStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertFalse(stack.searchPreserve("D"));

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }
}
