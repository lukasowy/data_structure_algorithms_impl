package linkedlist;

import java.util.Stack;


public class LinkedList {

    private static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            super();
            this.data = data;
        }
    }

    private Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head, prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    void deleteDups(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    int printKthToLast(Node head, int k) {
        if (head.next == null) {
            return -1;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.next.data);
        }
        return index;
    }

    public Node nthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            if (p1 == null)
                return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    Node partition(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    Node partition1(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    boolean isPalindrome(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data); // Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(Node one, Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    boolean isPalindrome2(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    int length(Node node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(5);
        list.append(2);
        list.append(7);
        list.append(2);
        list.append(5);
        list.append(1);
        list.append(11);
        list.printList();

        System.out.println();
        list.deleteDups(list.head);
        list.printList();

        System.out.println();
        list.printKthToLast(list.head, 7);
        System.out.println(list.nthToLast(list.head, 1).data);

        list.deleteNode(list.head.next.next);
        list.printList();

        list.partition(list.head, 5);
        System.out.println();
        list.printList();

        list.partition1(list.head, 5);
        System.out.println();
        list.printList();

        System.out.println();
        Node newHead = list.reverseAndClone(list.head);
        System.out.println(list.isEqual(newHead, list.head));
        boolean isEqual2 = list.isPalindrome2(list.head);
        System.out.println(isEqual2);
        int size = list.length(list.head);
        System.out.println("Size of list: " + size);
        System.out.println(list.findBeginning(list.head));
    }

}

