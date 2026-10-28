package com.codigoperaza.ds;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class Stack<T> {

    private Node<T> top;
    private int size;

    public void push(T value) {
        top = new Node<>(Objects.requireNonNull(value, "value"), top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
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
