
import SearchingAlgorithm.ExponentialSearch;

public class Main {
    public static void main (String[] arg) {
        int[] array = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
        var search = new ExponentialSearch();
        var result = search.search(array, 30);
        System.out.println(result);
    }


}
