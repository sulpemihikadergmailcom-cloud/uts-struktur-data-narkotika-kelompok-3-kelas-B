package com.kelompok.narkotika.structure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    @Test
    void testEnqueueAndPeek() {
        CustomQueue<String> queue = new CustomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeue() {
        CustomQueue<String> queue = new CustomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testClear() {
        CustomQueue<String> queue = new CustomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");

        queue.clear();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testIsEmpty() {
        CustomQueue<String> queue = new CustomQueue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("A");

        assertFalse(queue.isEmpty());
    }

    @Test
    void testSize() {
        CustomQueue<String> queue = new CustomQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals(3, queue.size());
    }
}

