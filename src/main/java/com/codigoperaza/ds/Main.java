package com.codigoperaza.ds;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("primero");
        stack.push("segundo");
        System.out.println("Pila LIFO: " + stack.pop() + ", " + stack.pop());

        Queue<String> queue = new Queue<>();
        queue.enqueue("primero");
        queue.enqueue("segundo");
        System.out.println("Cola FIFO: " + queue.dequeue() + ", " + queue.dequeue());

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        System.out.println("Lista: " + list.toList() + " | contiene 20: " + list.contains(20));

        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13}) {
            tree.insert(value);
        }
        System.out.println("Árbol in-order: " + tree.inOrder() + " | altura: " + tree.height());

        System.out.println("Balance de corchetes: " + BracketValidator.isBalanced("{[()]}"));
    }
}
