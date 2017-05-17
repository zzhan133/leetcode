package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, ans, 0, path);
        return ans;
    }

	private void dfs(int[] candidates, int target, List<List<Integer>> ans, int startIndex, List<Integer> path) {
		if(target == 0) {
			ans.add(new ArrayList<Integer> (path));
		}
		
		if(target < 0) return;
		
		for (int i = startIndex; i < candidates.length; i++) {
			path.add(candidates[i]);
			dfs(candidates, target - candidates[i], ans, i, path);
			path.remove(path.size() - 1);
		}
		
	}
}
