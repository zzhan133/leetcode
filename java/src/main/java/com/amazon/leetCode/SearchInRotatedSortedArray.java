package com.amazon.leetCode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] < target) {
                if(nums[right] < nums[middle]) {
                    left = middle + 1;
                } else {
                    if(nums[right] >= target) {
                    	left = middle + 1;
                    } else {
                    	right = middle - 1;
                    }
                }
                
            } else {
            	if(nums[middle] > nums[right]) {
            		if (nums[left] <= target) {
						right = middle - 1;
					} else {
						left = middle + 1;
					}
            	} else {
            		right = middle - 1;
            	}
            }
        }
        return -1;
    }

}
