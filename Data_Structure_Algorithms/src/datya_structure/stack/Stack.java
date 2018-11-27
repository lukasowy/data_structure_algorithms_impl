package datya_structure.stack;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
    private int count = 0;
    private Node<T> top = null;

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        count--;

        return item;
    }

    public void push(T data){
        Node<T> node = new Node<>(data); // ---> fresh reference
        node.next = top; // ---> outdated reference
        top = node; // ---> fresh reference
        count++;
    }

    public T peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int length(){
        return count;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        System.out.println(stack.top.data);
        stack.push(30);
        stack.push(30);
        stack.pop();
        System.out.println(stack.length());
    }
}
