package DataStructures.Heaps;

public class MinHeap {
    private static class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] node = new Node[10];
    private int size;

    public void insert(int number, String value) {
        if (isFull())
            throw new IllegalStateException();

        Node newNode = new Node(number, value);
        node[size++] = newNode;

        bubbleUp();
    }

    public int remove() {
        int root = node[0].key;
        node[0] = node[--size];

        bubbleDown();

        return root;
    }

    public void bubbleUp() {
        int index = size - 1;

        while (index > 0 && node[index].key < node[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void bubbleDown() {
        int index = 0;
        while (index <= size && isValidParent(index)) {
            int smallerIndex = smallerChildIndex(index);

            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    private void swap(int first, int second) {
        Node temp = node[first];
        node[first] = node[second];
        node[second] = temp;
    }

    private int leftChildIndex(int index) {
        return (index * 2 + 1);
    }

    private int rightChildIndex(int index) {
        return (index * 2 + 2);
    }

    private boolean hasLeftChild(int index)  {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return false;

        boolean isValid = node[index].key > leftChild(index);

        if (hasRightChild(index))
            isValid &= node[index].key < rightChild(index);

        return isValid;
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        else if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) < rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChild(int index) {
        return node[leftChildIndex(index)].key;
    }

    private int rightChild(int index) {
        return node[rightChildIndex(index)].key;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == node.length;
    }
}
