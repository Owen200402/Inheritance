package Algorithms;

public class CountingSort {
    public void sort(int[] array) {
        int count = 0;

        for (int item : array) {
            if (item > count)
                count = item;
        }

        sort(array, count);
    }

    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for (int item : array)
            counts[item]++;

        int counter = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[counter] = i;
                counter++;
            }
        }
    }
}
