package DataStructures.Heaps;

public class MaxHeap {
    public static void heapify(int[] array) {
        int lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        int leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap (int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heaps heaps = new Heaps();

        for (int j : array)
            heaps.insert(j);


        for (int i = 0; i < k - 1; i++)
            heaps.remove();
            // when removing a heap, its sequence is always from
            // biggest to the smallest


        return heaps.max();
    }


}
