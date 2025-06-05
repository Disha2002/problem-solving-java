package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

// pseudo code
// function combinationSum(candidates, target):
//     result = empty list to store combinations
//     current = empty list to build one combination
//     backtrack(0, target, current, result)

// function backtrack(startIndex, remainingTarget, current, result):
//     if remainingTarget == 0:
//         add a copy of current to result
//         return
//     if remainingTarget < 0:
//         return

//     for i from startIndex to candidates.length - 1:
//         add candidates[i] to current
//         backtrack(i, remainingTarget - candidates[i], current, result)  // Note: 'i' to allow reuse
//         remove last element from current  // Backtrack

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, target, current, result, candidates);
        return result;
    }

    private void backtrack(int index, int remainingTarget, List<Integer> current, List<List<Integer>> result,
            int[] candidates) {

        if (remainingTarget == 0) {
            result.add(new ArrayList<>(current));
        }

        if (remainingTarget < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(i, remainingTarget - candidates[i], current, result, candidates);
            current.remove(current.size() - 1);
        }
    }

}
