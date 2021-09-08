import DataStructures.LinkedList.LinkedList;

public class Main {
    public static void main (String[] arg) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println(list.getKthFromTheEnd(5));
    }
}


