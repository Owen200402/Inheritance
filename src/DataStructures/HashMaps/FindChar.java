package DataStructures.HashMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindChar {
    public char findChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = str.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                var count = map.get(ch);
                map.put(ch, count + 1);
            }
            else
                map.put(ch, 1);
        }

        for (char ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE; // none existing character
    }

    public char findRepeatedCh(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch: str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
