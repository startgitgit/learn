package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/6/8 20:40
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1, i = 0, j = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while (j < s.length()) {
            if (set.contains(s.charAt(j)))
                set.remove(s.charAt(i++));
            else
                set.add(s.charAt(j++));
            max = Math.max(max, j - i);
        }
        return max;
    }
}