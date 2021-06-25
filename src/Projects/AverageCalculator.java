package Projects;

import java.util.ArrayList;

public class AverageCalculator {
    public static void show() {
        int sum = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(95);
        arrayList.add(93);
        arrayList.add(100);
        arrayList.add(98);

        for (Integer integer : arrayList) {
            sum = sum + integer;
        }

        double average = (double)sum / arrayList.size();

        System.out.println(average);
    }
}
