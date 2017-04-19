package com.mv.leetCode;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums == null) {
			return 0;
		}
		int low = 0;
		int high = nums.length - 1;
		while(low < high) {
			int middle = (low + high) / 2;
			int midV = nums[middle];
			if(midV < nums[high]) { //normal sorted array
				high = middle;
			} else if(midV > nums[high]) {
				low = middle + 1;
			} 
		}
		
		return nums[low];
	}
}
