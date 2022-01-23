package Algorithms;

public class BubbleSort {
    public void sort(int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1, array);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private void swap(int num1, int num2, int[] array) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
