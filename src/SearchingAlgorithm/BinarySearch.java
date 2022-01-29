package SearchingAlgorithm;

public class BinarySearch {
    public int searchRec(int[] array, int target) {
        return searchRec(array, target, 0, array.length - 1);
    }

    public int searchRec(int[] array, int target, int left, int right) {
        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (array[middle] > target)
            return searchRec(array, target, left, middle - 1);

        return searchRec(array, target, middle + 1, right);
    }

    public int searchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (array[middle] == target)
                return middle;
            if (array[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }
}
