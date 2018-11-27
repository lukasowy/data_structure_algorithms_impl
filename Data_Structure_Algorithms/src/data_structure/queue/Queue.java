package data_structure.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (tail != null)
            tail.next = node;

        tail = node;

        if (head == null)
            head = tail;
    }

    public T remove() {
        if (head == null)
            throw new NoSuchElementException();

        T data = head.data;
        head = head.next;

        if (head == null)
            tail = null;

        return data;
    }

    public T peek() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        System.out.println(queue.isEmpty());
        queue.add(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        queue.add(43);
        queue.add(13);
        queue.add(12);
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }
}
