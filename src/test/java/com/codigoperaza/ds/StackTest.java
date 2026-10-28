package com.codigoperaza.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void pushAndPopKeepLifoOrder() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekDoesNotRemoveTheTop() {
        Stack<String> stack = new Stack<>();
        stack.push("a");

        assertEquals("a", stack.peek());
        assertEquals("a", stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void emptyStackThrowsWhenPoppingOrPeeking() {
        Stack<String> stack = new Stack<>();

        assertThrows(NoSuchElementException.class, stack::pop);
        assertThrows(NoSuchElementException.class, stack::peek);
    }

    @Test
    void rejectsNullValues() {
        Stack<String> stack = new Stack<>();

        assertThrows(NullPointerException.class, () -> stack.push(null));
    }
}
