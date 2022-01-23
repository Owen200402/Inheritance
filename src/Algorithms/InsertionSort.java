package Algorithms;

public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            for (int j = i - 1; j > -1; j--) {
                if (array[j] > current) {
                    array[j + 1] = array[j];
                    array[j] = current;
                }
            }
        }
    }
}
