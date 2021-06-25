package DataStructures.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private static class Node {
        private int value;
        private Node next;
        private Node nextBackUp;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if(isEmpty())
            first = last = node;

        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while(current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
//        var current = first;
//
//        while(current != null) {
//            if(current.value == item)
//                return true;
//            current = current.next;
//        }
//        return false;
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        }
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        }
        else {
            var current = first;
            Node secondLast = null;

            while (current != last) {
                secondLast = current;
                current = current.next;
            }

            secondLast.next = null;
            last = secondLast;
        }

        size--;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while(current != null) {
            array[index] = current.value;
            index++;
            current = current.next;
        }
        return array;
    }

    public void reverse() { //self-implemented
//        var current = first;
//        while(current != last) {
//            current.nextBackUp = current.next;
//            current = current.next;
//        }
//
//        current = first;
//        while(current != last) {
//            var second = current.nextBackUp;
//
//            if(current == first) {
//                second.next = current;
//                current.next = null;
//                current.nextBackUp = null;
//                current = second;
//            }
//            else {
//                second.next = current;
//                current.nextBackUp = null;
//                current = second;
//            }
//        }
//
//        last = first;
//        first = current;
//
        // Mosh's solution:
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        Node pointer1 = first;
        Node pointer2 = first;

        for (int i = 0; i < k - 1; i++) {
            pointer2 = pointer2.next;

            if(pointer2 == null) {
                throw new IllegalArgumentException();
            }
        }

        while (pointer2 != last) {
            pointer2 = pointer2.next;
            pointer1 = pointer1.next;
        }

        return pointer1.value;
    }

    public void printMiddle() {
        if (isEmpty()) throw new IllegalStateException();

        var pointer1 = first;
        var pointer2 = first;

        while(pointer1 != last && pointer1.next != last) {
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
        }

        if (pointer1 == last) // if having odd numbers of nodes here
            System.out.println(pointer2.value);
        else { // if the node # is even
            System.out.println(pointer2.value + ", " + pointer2.next.value);
        }

    }

    public boolean hasLoop() {
        var pointer1 = first;
        var pointer2 = first;

        while (pointer1 != null && pointer1.next != null) {
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
            if (pointer1 == pointer2)
                return true;
        }
        return false;
    }

    private boolean isEmpty() {
        return first == null;
    }

}
