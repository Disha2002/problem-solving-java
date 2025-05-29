package DataStructure.Backtracking;

import java.util.ArrayList;
import java.util.List;

// pseudo code
// function partition(s):
//     result = empty list of list of strings
//     currentPartition = empty list of strings

//     backtrack(startIndex = 0, s, currentPartition, result)

//     return result

// function backtrack(startIndex, s, currentPartition, result):
//     if startIndex == length of s:
//         // We reached the end of the string, currentPartition is a valid solution
//         add a copy of currentPartition to result
//         return

//     for endIndex from startIndex to length of s - 1:
//         substring = s.substring(startIndex, endIndex + 1)
//         if isPalindrome(substring):
//             add substring to currentPartition
//             backtrack(endIndex + 1, s, currentPartition, result)
//             remove last substring from currentPartition  // Backtrack

// function isPalindrome(str):
//     left = 0
//     right = length of str - 1
//     while left < right:
//         if str[left] != str[right]:
//             return false
//         left += 1
//         right -= 1
//     return true

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(0, s, result, current);
        return result;
    }

    private void backtrack(int index, String s, List<List<String>> result, List<String> current) {
        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            if (isPalindrome(subString)) {
                current.add(subString);
                backtrack(i + 1, s, result, current);
                current.remove(current.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
