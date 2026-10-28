package com.codigoperaza.ds;

import java.util.ArrayList;
import java.util.List;

public final class BinarySearchTree {

    private Node root;
    private int size;

    public boolean insert(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return true;
        }
        boolean inserted = insert(root, value);
        if (inserted) {
            size++;
        }
        return inserted;
    }

    private boolean insert(Node node, int value) {
        if (value == node.value) {
            return false;
        }
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                return true;
            }
            return insert(node.left, value);
        }
        if (node.right == null) {
            node.right = new Node(value);
            return true;
        }
        return insert(node.right, value);
    }

    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            }
            current = value < current.value ? current.left : current.right;
        }
        return false;
    }

    public List<Integer> inOrder() {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        return List.copyOf(values);
    }

    private void inOrder(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrder(node.left, values);
        values.add(node.value);
        inOrder(node.right, values);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    private static final class Node {
        private final int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }
}
