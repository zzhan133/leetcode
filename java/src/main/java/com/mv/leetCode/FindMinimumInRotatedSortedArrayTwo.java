package com.mv.leetCode;

public class FindMinimumInRotatedSortedArrayTwo {

	public int findMin(int[] nums) {
		if (nums == null) {
			return 0;
		}
		return findMin(nums, 0, nums.length - 1);
	}
	
	private int findMin(int[] nums, int left, int right) {
		if(left >= right) {
			return nums[left];
		}
		int middle = (left + right) / 2;
		int midV = nums[middle];
		if(midV < nums[right]) {
			return findMin(nums, left, middle);
		} else if(midV > nums[right]) {
			return findMin(nums, middle + 1, right);
		} else {
			return Math.min(findMin(nums,left, middle), findMin(nums, middle, right - 1));
		}
	}
}
