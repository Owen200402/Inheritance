package Algorithms;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            swap(i, minIndex, array);
        }
    }

    private void swap(int num1, int num2, int[] array) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
