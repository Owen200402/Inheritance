package DataStructures.BinaryTrees;

public class Tree {
    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    return;
                }
                current = current.leftChild;
            }

            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    return;
                }
                current = current.rightChild;
            }
        }
    }
}
