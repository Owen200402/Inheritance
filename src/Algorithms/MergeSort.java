package Algorithms;

public class MergeSort {
    public void sort(int[] array) {
        if (array.length < 2)
            return;

        int middle = array.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int pointer1 = 0;
        int pointer2 = 0;
        int resultCount = 0;

        while (resultCount < left.length + right.length) {
            if (pointer1 == left.length)
                result[resultCount++] = right[pointer2++];
            else if (pointer2 == right.length)
                result[resultCount++] = left[pointer1++];
            else if (left[pointer1] <= right[pointer2])
                result[resultCount++] = left[pointer1++];
            else if (left[pointer1] >= right[pointer2])
                result[resultCount++] = right[pointer2++];
        }
    }
}
