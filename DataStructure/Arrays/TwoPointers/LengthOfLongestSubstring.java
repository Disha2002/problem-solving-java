package DataStructure.Arrays.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
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

    // more efficient

    public int lengthOfLongestSubstringEfficient(String s) {

        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            int current = s.charAt(end);
            if (lastSeen[current] >= start) {
                start = lastSeen[current] + 1;
            }
            lastSeen[current] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
