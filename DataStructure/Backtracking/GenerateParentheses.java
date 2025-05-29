package DataStructure.Backtracking;

import java.util.ArrayList;
import java.util.List;

//Walk through the entire space of possible strings made of '(' and ')', but only keep the ones that:
//1. Are balanced (valid nesting),
//2. Use exactly n '(' and n ')',
//3. Are unique (this comes for free if we don’t duplicate during generation).

//pseudocode
// function generate(n):
//         result = []
//         backtrack(current, open = 0, close = 0)
//         return result

// function backtrack(current, open, close):
//         if length of current = 2*n:
//             add current to result
//             return
//         if open < n:
//             backtrack(current + "(", open+1, close)
//         if close < open:
//             backtrack(current + ")", open, close+1)
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String current, int open, int close, int n, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            backtrack(current + "(", open + 1, close, n, result);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, n, result);
        }
    }

}
