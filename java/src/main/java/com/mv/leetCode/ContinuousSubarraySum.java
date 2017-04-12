package com.mv.leetCode;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length < 2) {
			return false;
		}
		
		if(k == 0) {
			return true;
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			if(isSumForFixStartIndex(nums, k, i))
				return true;
		}
		return false;
	}

	private boolean isSumForFixStartIndex(int[] nums, int k, int startIndex) {
		int previousSum = 0;
		for (int i = startIndex; i < nums.length; i++) {
			previousSum += nums[i];
			if (previousSum % k == 0) {
				return true;
			}
		}
		return false;
	}

}
