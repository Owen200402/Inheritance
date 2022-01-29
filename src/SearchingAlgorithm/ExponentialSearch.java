package SearchingAlgorithm;

public class ExponentialSearch {
    public int search(int[] array, int target) {
        int bound = 1;
        while (bound < array.length && array[bound] < target)
                bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        var binarySearch = new BinarySearch();
        return binarySearch.searchRec(array, target, left, right);
    }
}
