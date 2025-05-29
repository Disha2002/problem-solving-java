package DataStructure.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

class LongestSubStringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {

        int res = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char current = s.charAt(end);
            if (!set.contains(s.charAt(end))) {
                set.add(current);
                res = Math.max(res, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return res;
    }
}
