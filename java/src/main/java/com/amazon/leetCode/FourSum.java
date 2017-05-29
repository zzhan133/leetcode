package com.amazon.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> ans = new ArrayList<>();
    	Arrays.sort(nums);
    	List<Integer> item = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
    		if(i > 0 && nums[i] == nums[i-1])
    			continue;
    		item.add(nums[i]);
			threeSum(nums, ans, item, i + 1, target - nums[i]);
			item.remove(item.size() - 1);
		}
    	return ans;
        
    }

	private void threeSum(int[] nums, List<List<Integer>> ans, List<Integer> item, int pos, int target) {
		for (int i = pos; i < nums.length; i++) {
    		if(i > pos && nums[i] == nums[i-1])
    			continue;
			item.add(nums[i]);
			twoSum(nums, ans, item, i+1, target - nums[i]);
			item.remove(item.size() - 1);
		}
		
	}

	private void twoSum(int[] nums, List<List<Integer>> ans, List<Integer> item, int pos, int target) {
		int left = pos;
		int right = nums.length - 1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(sum == target){
				item.add(nums[left]);
				item.add(nums[right]);
				ans.add(new ArrayList<>(item));
				item.remove(item.size() - 1);
				item.remove(item.size() - 1);
				while(++left < right && nums[left] == nums[left-1]);
				while(left < --right && nums[right] == nums[right+1]);
			} else if(sum < target) {
				if( 2 * nums[right] < target)
					return;
				left++;
			} else {
				if(2 * nums[left] > target)
					return;
				right--;
			}
		}
		
	}
}
