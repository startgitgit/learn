package alg;

import java.util.HashMap;

public class MaxLengthNoDuplicateString {
    public int getMaxLength(String s) {
        int start = 0, end = 0;
        int maxlength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(start)) + 1);
            }
            map.put(s.charAt(end), end);
            maxlength = Math.max(maxlength, end - start + 1);
        }
        return maxlength;

    }
}
