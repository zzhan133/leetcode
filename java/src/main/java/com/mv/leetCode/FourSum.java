package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
        	if(i != 0 && nums[i] == nums[i-1]) {
        		continue;
        	}
        	if(nums[i] > 0 && nums[i] > target) {
        		break;
        	}
        	int[] item = new int[4];
        	item[0] = nums[i];
        	threeSum(nums, target - nums[i], i + 1, nums.length - 1, item, ans);
			
		}
        return ans;
    }
    
    private void threeSum(int[] nums, int target, int low, int high, int[] item, List<List<Integer>> ans){
    	for (int i = low; i <= high; i++) {
    		if(i > low && nums[i] == nums[i-1]) {
        		continue;
        	}
    		
			item[1] = nums[i];
			twoSum(nums, target - nums[i], i+1, high, item, ans);
		}
    }

	private void twoSum(int[] nums, int target, int low, int high, int[] item, List<List<Integer>> ans) {
		int origLow = low;
		int origHigh = high;
		while(low < high) {
			while(low > origLow && low < high && nums[low] == nums[low -1]) {
				low++;
			}
			while(high < origHigh && low < high && nums[high] == nums[high + 1]) {
				high--;
			}
			if(low == high) {
				break;
			}
			if(nums[low] + nums[high] == target) {
				item[2] = nums[low];
				item[3] = nums[high];
				List<Integer> tmp = new ArrayList<>(Arrays.asList(item[0],item[1],item[2],item[3] ));
				ans.add(tmp);
				low++;
				high--;
			} else if(nums[low] + nums[high] > target) {
				high--;
			} else {
				low++;
			}
		}
	}

}
