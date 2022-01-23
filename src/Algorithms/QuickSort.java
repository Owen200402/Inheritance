package Algorithms;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;

        int boundary = partition(array, start, end);

        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    public int partition(int[] array, int start, int end) {
        int boundary = start - 1;
        int pivot = array[end];
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot){
                boundary++;
                swap(i, boundary, array);
            }
        }

        return boundary;
    }

    private void swap(int num1, int num2, int[] array) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
