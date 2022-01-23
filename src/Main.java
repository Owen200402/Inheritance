import SearchingAlgorithm.LinearSearch;

public class Main {
    public static void main (String[] arg) {
        int[] array = { 6, 2, 5, 4, 3, 7 };
        var search = new LinearSearch();
        var result = search.search(array, 2);
        System.out.println(result);
    }
}
