package com.codigoperaza.ds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void insertsAndFindsValues() {
        BinarySearchTree tree = new BinarySearchTree();

        assertTrue(tree.insert(5));
        assertTrue(tree.insert(3));
        assertTrue(tree.insert(8));

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(8));
        assertFalse(tree.contains(4));
        assertEquals(3, tree.size());
    }

    @Test
    void ignoresDuplicates() {
        BinarySearchTree tree = new BinarySearchTree();

        assertTrue(tree.insert(5));
        assertFalse(tree.insert(5));
        assertEquals(1, tree.size());
    }

    @Test
    void inOrderReturnsSortedValues() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13}) {
            tree.insert(value);
        }

        assertEquals(List.of(1, 3, 4, 6, 7, 8, 10, 13, 14), tree.inOrder());
    }

    @Test
    void heightHandlesEmptySingleAndNestedTrees() {
        BinarySearchTree tree = new BinarySearchTree();

        assertEquals(0, tree.height());
        assertTrue(tree.isEmpty());

        tree.insert(5);
        assertEquals(1, tree.height());

        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        assertEquals(3, tree.height());
    }

    @Test
    void emptyTreeDoesNotContainValues() {
        BinarySearchTree tree = new BinarySearchTree();

        assertFalse(tree.contains(1));
        assertTrue(tree.inOrder().isEmpty());
        assertEquals(0, tree.size());
    }
}
