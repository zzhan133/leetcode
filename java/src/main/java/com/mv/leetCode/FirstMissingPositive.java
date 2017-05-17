package com.mv.leetCode;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		if (nums == null || (nums.length == 1 && nums[0] != 1)) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] - 1;
		}
		for (int i = 0; i < nums.length; i++) {
			int newValue = nums[i];
			int backup = 0;
			while (newValue >= 0 && newValue < nums.length && newValue != nums[newValue]) {
				backup = nums[newValue];
				nums[newValue] = newValue;
				newValue = backup;
			}

		}
		for (int i = 0; i < nums.length; i++) {
			if(i != nums[i]) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

}
