package DataStructures.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {
    public int mostFrequent(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (var current : array) {
            if (map.containsKey(current)) {
                int value = map.get(current);
                map.put(current, value + 1);
            }
            else
                map.put(current, 1);
        }

        int max = 0;
        int result = 0;
        for (var num : map.entrySet()) {
            if (num.getValue() > max) {
                max = num.getValue();
                result = num.getKey();
            }
        }
        return result;
    }

    public int countPairsWithDiff(int[] array, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            set.add(num);
        }

        int count = 0;
        for (var current : array) { // a linear search
                if (set.contains(current + k))
                    count++;
                if (set.contains(current - k))
                    count++;
                set.remove(current);
        }

        return count;
    }

//    public int[] twoSum(int[] array, int target) {
//        int[] array2 = new int[2];
//
//        for (int i = 0; i < array.length; i++) {
//            var current = array[i];
//            for (int j = i + 1; j < array.length; j++) {
//                var pointer = array[j];
//                if (current + pointer == target) {
//                    array2[0] = i;
//                    array2[1] = j;
//                    break;
//                }
//            }
//
//        }
//        return array2;
//    }

    public int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            else
                map.put(array[i], i);
        }

        return null;
    }

}
