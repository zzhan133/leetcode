package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		if(nums == null || nums.length < 4) {
			return ans;
		}
		Arrays.sort(nums);
		int[] item = new int[4];
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] > 0 && nums[i] > target) {
				break;
			}
			item[0] = nums[i];
			int targetThree = target - item[0];
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if (nums[j] > 0 && nums[j] > targetThree)
					break;
				item[1] = nums[j];
				int targetTwo = targetThree - item[1];
				int low = j + 1, high = nums.length - 1;
				while (low < high) {
					while (low > j + 1 && low < high && nums[low] == nums[low - 1]) {
						low++;
					}
					while (high < nums.length - 1 && low < high && nums[high] == nums[high + 1]) {
						high--;
					}
					if (low == high)
						break;
					if (nums[low] + nums[high] == targetTwo) {
						item[2] = nums[low];
						item[3] = nums[high];
						List<Integer> tmp = new ArrayList<>(Arrays.asList(item[0], item[1], item[2], item[3]));
						ans.add(tmp);
						low++;
						high--;
					} else if (nums[low] + nums[high] > targetTwo) {
						high--;
					} else {
						low++;
					}
				}
			}

		}
		return ans;
	}
}
