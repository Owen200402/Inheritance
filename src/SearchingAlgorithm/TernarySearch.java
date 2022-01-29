package SearchingAlgorithm;

public class TernarySearch {
    public int searchRec(int[] array, int target) {
        return searchRec(array, target, 0, array.length - 1);
    }

    private int searchRec(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (target > array[mid2])
            return searchRec(array, target,mid2 + 1, right);
        if (target < array[mid1])
            return searchRec(array, target, left, mid1 - 1);

        if (target == array[mid1])
            return mid1;
        if (target == array[mid2])
            return mid2;

        return searchRec(array, target, mid1 + 1, mid2 - 1);
    }
}
