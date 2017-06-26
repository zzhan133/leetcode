package com.amazon.leetCode;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		return snum(nums, 0, nums.length - 1);
	}

	private int snum(int[] nums, int left, int right) {
		if (left >= right)
			return nums[left];
		int val = nums[right];
		int pivot = getPivot(nums, left, right);
		if (pivot == -1)
			return val;
		else if ((pivot - left) % 2 == 1)
			return snum(nums, left, pivot - 1);
		else
			return snum(nums, pivot, right - 2);
	}

	private int getPivot(int[] nums, int left, int right) {
		int defRight = right;
		int val = nums[right--];
		boolean hasSame = val == nums[right];
		while (left < right) {
			while (left < right && nums[left] <= val) {
				if (nums[left] == val) {
					hasSame = true;
					nums[left] = nums[defRight - 1];
					nums[defRight - 1] = val;
					left--;
				}
				left++;
			}
			while (left < right && nums[right] >= val) {
				if (nums[right] == val) {
					hasSame = true;
					nums[right] = nums[defRight - 1];
					nums[defRight - 1] = val;
				}
				right--;
			}

			if (left < right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}

		}

		if (!hasSame)
			return -1;
		else
			return left;
	}

}
