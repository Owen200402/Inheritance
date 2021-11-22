import DataStructures.Heaps.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main (String[] arg) {
        int[] numbers = {7, 8, 9, 5, 4, 3, 10};
        MaxHeap.heapify(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}


