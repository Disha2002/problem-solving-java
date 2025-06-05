package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//pseudo code
// function permute(nums):
//     result = empty list of list
//     current = empty list
//     used = boolean array of same length as nums

//     backtrack():
//         if current.size == nums.length:
//             add a copy of current to result
//             return

//         for i from 0 to nums.length - 1:
//             if used[i] is false:
//                 mark used[i] = true
//                 add nums[i] to current
//                 call backtrack()
//                 remove last element from current
//                 mark used[i] = false

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(current, nums, result, used);
        return result;
    }

    private void backtrack(List<Integer> current, int[] nums, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrack(current, nums, result, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }

    }
}
