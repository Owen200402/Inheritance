package Projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrangingBooks {
    public static void arrange() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = in.readLine().toCharArray();

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'L')
                array.add(1);
            if (charArray[i] == 'M')
                array.add(2);
            if (charArray[i] == 'S')
                array.add(3);
        }

        int num = sort(array);
        System.out.println(num);
    }

    private static int sort(ArrayList<Integer> arr) {
        int count = 0;
        boolean triggered = false;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    // Edge Case
                    if (arr.get(i) == 3)
                        for (int k = arr.size() - 1; k > i; k--) {
                            if (arr.get(k) == 1) {
                                arr.set(i, 1);
                                arr.set(k, 3);
                                count++;
                                triggered = true;
                                break;
                            }
                        }
                    //Swap
                    if (!triggered) {
                        int num = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, num);
                        count++;
                    }
                    triggered = false;
                }
            }
        }
        return count;
    }
}
