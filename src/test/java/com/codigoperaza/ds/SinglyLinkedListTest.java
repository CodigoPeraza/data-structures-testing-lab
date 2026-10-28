package com.codigoperaza.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void addFirstAndAddLastKeepTheExpectedOrder() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);

        assertEquals(List.of(1, 2, 3), list.toList());
        assertEquals(3, list.size());
    }

    @Test
    void removeDeletesOnlyTheFirstOccurrence() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);

        assertTrue(list.remove(2));
        assertEquals(List.of(1, 2, 3), list.toList());
        assertFalse(list.remove(9));
        assertEquals(3, list.size());
    }

    @Test
    void containsAndSizeReflectTheCurrentContent() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("a");

        assertTrue(list.contains("a"));
        assertFalse(list.contains("b"));
        assertEquals(1, list.size());
    }

    @Test
    void removesTheHeadWhenItMatches() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);

        assertTrue(list.remove(1));
        assertEquals(List.of(2), list.toList());
    }

    @Test
    void toListReturnsAnImmutableSnapshot() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);

        List<Integer> snapshot = list.toList();

        assertThrows(UnsupportedOperationException.class, () -> snapshot.add(2));
        assertEquals(List.of(1), list.toList());
    }

    @Test
    void rejectsNullValues() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        assertThrows(NullPointerException.class, () -> list.addFirst(null));
        assertThrows(NullPointerException.class, () -> list.addLast(null));
    }
}
