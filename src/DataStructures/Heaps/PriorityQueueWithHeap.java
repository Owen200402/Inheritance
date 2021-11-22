package DataStructures.Heaps;

public class PriorityQueueWithHeap {
    private Heaps heap = new Heaps();

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
