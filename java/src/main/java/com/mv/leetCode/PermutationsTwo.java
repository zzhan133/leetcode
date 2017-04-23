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
        permute(nums, 0, ans);
        return ans;
    }
    
    private void permute(int[] nums, int beginIndex, List<List<Integer>> ans) {
    	if(beginIndex == nums.length) {
    		ArrayList<Integer> tmp = new ArrayList<>();
    		for(int a: nums) tmp.add(a);
    		ans.add(new ArrayList<Integer>(tmp));
    		return;
    	}
    	for (int i = beginIndex; i < nums.length; i++) {
    		boolean skip = false;
    		for (int j = beginIndex; j < i; j++) {
				if(nums[j] == nums[i]){
					skip = true;
					break;
				}
			}
    		if(skip) continue;
    		swap(nums, beginIndex,i);
			permute(nums, beginIndex+1, ans);
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
