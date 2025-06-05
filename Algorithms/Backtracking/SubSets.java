package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

// pseudo code
// function subsets(nums):
//     result = empty list to store all subsets
//     current = empty list to store current subset

//     backtrack(startIndex):
//         add a copy of current to result

//         for i from startIndex to length of nums - 1:
//             add nums[i] to current       // Choose
//             backtrack(i + 1)             // Explore
//             remove last element from current  // Un-choose (backtrack)

//     backtrack(0)
//     return result
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, result, current, nums);
        return result;
    }

    private void backtrack(int index, List<List<Integer>> result, List<Integer> current, int[] nums) {
        result.add(new ArrayList<>(current)); // just current adds reference not a copy
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, result, current, nums);
            current.remove(current.size() - 1);
        }
    }

}
