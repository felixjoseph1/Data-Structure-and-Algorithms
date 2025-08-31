package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        // Base case: if the current permutation is complete
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;}
            // Iterate through each number to generate permutations
            for (int i = 0; i < nums.length; i++) {
                // If the number is already used in current permutation, skip it
                if (tempList.contains(nums[i])) continue;

                // Decision: include nums[i] in current permutation
                tempList.add(nums[i]);

                // Recur to build the rest of the permutation
                backtrack(nums, result, tempList);

                // Backtrack: undo the decision
                tempList.removeLast();
            
        }
    }
}
