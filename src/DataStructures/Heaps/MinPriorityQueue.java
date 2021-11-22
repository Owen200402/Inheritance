package DataStructures.Heaps;

public class MinPriorityQueue {
    private MinHeap heap = new MinHeap();

    public void add(String value, int priority) {
        heap.insert(priority, value);
    }

    public int remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
