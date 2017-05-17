package com.mv.leetCode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
    	if(nums == null || nums.length == 1 && nums[0] <= 0) {
    		return 1;
    	}
    	int left = -1;
    	int right = nums.length;
    	while(left < right) {
    		//1. left is empty -> nums.length;
    		//2. left is bigger than 0;
    		//nums[left] == nums[right];
    		while(++left < right && nums[left] <= 0);

    		
    		//1. right == left;
    		//2. nums[right] <= 0;
    		while(--right > left && nums[right] > 0);
    		
    		// nums[left] is greater than 0;
    		if(left < right) {
        		int tmp = nums[left];
        		nums[left] = nums[right];
        		nums[right] = tmp;
    		}
    	}
    	
    	if(left == nums.length) return 1;
    	
    	//left is the first element greater than 0;
    	int size = nums.length - left;
    	int calSum = size * (size + 1) / 2;
    	int sum = 0;
    	while(left < nums.length) {
    		sum += nums[left];
    		left++;
    	}
    	
    	if(sum == calSum) {
    		return size + 1;
    	}
    	
    	return calSum + size + 1 - sum;
    }

}
