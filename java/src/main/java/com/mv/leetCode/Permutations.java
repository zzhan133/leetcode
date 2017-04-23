package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums == null || nums.length == 0) return ans;
        Integer[] item = new Integer[nums.length];
        permute(nums, 0, ans, item);
        return ans;
    }
    
    private void permute(int[] nums, int beginIndex, List<List<Integer>> ans, Integer[] item) {
    	if(beginIndex == nums.length) {
    		ans.add(new ArrayList<Integer>(Arrays.asList(item)));
    		return;
    	}
    	for (int i = beginIndex; i < nums.length; i++) {
			item[beginIndex] = nums[i];
    		swap(nums, beginIndex, i);
			permute(nums, beginIndex+1, ans, item);
			swap(nums, beginIndex, i);
		}
    }
    
    private void swap(int[] nums, int beginIndex, int i) {
    	if(beginIndex == i) return;
    	int tmp = nums[i];
    	nums[i] = nums[beginIndex];
    	nums[beginIndex] = tmp;
	}

}
