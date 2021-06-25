package DataStructures.Queues;

import java.util.ArrayList;

public class LinkedListQueue {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int count;

    // O(1)
    public void enqueue(int item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        count++;
    }

    // O(1)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int firstValue = first.value;
        if (first == last) {
            first = last = null;
        }
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        count--;

        return firstValue;
    }

    // O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return first.value;
    }

    // O(1)
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // O(n)
    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        Node current = first;

        for (int i = 0; i < count; i++) {
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }
}