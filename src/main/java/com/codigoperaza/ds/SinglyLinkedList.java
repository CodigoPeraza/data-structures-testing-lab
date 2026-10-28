package com.codigoperaza.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        head = new Node<>(Objects.requireNonNull(value, "value"), head);
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(Objects.requireNonNull(value, "value"), null);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.value, value)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.value, value)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public List<T> toList() {
        List<T> values = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        return List.copyOf(values);
    }

    public int size() {
        return size;
    }

    private static final class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
