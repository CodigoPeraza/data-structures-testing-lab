package com.codigoperaza.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void enqueueAndDequeueKeepFifoOrder() {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void peekDoesNotRemoveTheFront() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");

        assertEquals("a", queue.peek());
        assertEquals("a", queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void emptyQueueThrowsWhenDequeuingOrPeeking() {
        Queue<String> queue = new Queue<>();

        assertThrows(NoSuchElementException.class, queue::dequeue);
        assertThrows(NoSuchElementException.class, queue::peek);
    }

    @Test
    void rejectsNullValues() {
        Queue<String> queue = new Queue<>();

        assertThrows(NullPointerException.class, () -> queue.enqueue(null));
    }
}
