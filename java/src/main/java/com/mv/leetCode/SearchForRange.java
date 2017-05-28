package com.mv.leetCode;

public class SearchForRange {

	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[2];
		ans[0] = findLeft(nums, 0, nums.length - 1, target);
		ans[1] = findRight(nums, 0, nums.length - 1, target);
		return ans;
	}
	
	private int findLeft(int[] nums, int low, int high, int target) {
		if(low > high)
			return -1;
		int mid = (low + high) / 2;
		if(nums[mid] == target) {
			int newLeft = findLeft(nums, low, mid - 1, target);
			if(newLeft == -1) 
				return mid;
			else 
				return newLeft;
		} else if(nums[mid] < target) {
			return findLeft(nums, mid + 1, high, target);
		} else {
			return findLeft(nums, low, mid - 1, target);
		}
	}
	
	private int findRight(int[] nums, int low, int high, int target) {
		if(low > high)
			return -1;
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			int newRight = findRight(nums, mid + 1, high, target);
			if (newRight == -1) {
				return mid;
			} else {
				return newRight;
			}
		} else if(nums[mid] < target) {
			return findRight(nums, mid + 1, high, target);
		} else {
			return findRight(nums, low, mid - 1, target);
		}
	}
}
