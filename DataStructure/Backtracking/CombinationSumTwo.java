package DataStructure.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > remainingTarget)
                break;
            current.add(candidates[i]);
            backtrack(i + 1, remainingTarget - candidates[i], current, result, candidates);
            current.remove(current.size() - 1);
        }
    }
}
