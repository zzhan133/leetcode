package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        LinkedList<Integer> item = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, ans, item, visited);
        return ans;
    }
    
    private void permute(int[] nums, List<List<Integer>> ans, LinkedList<Integer> item, boolean[] visited) {
    	if(item.size() == nums.length) {
    		ans.add(new ArrayList<>(item));
    		return;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if(visited[i]) continue;
    	    if(i > 0  && !visited[i-1] && nums[i] == nums[i-1]) continue;
			item.add(nums[i]);
			visited[i] = true;
			permute(nums, ans, item, visited);
			visited[i] = false;
			item.pollLast();
		}
    }
    
}
