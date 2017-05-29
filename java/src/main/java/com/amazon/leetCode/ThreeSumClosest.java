package com.amazon.leetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int twoSum = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == twoSum) return target;
                    else if (sum < twoSum) {
                    	int dc = twoSum - sum;
                    	if (dc < distance) {
							distance = dc;
							ans = twoSum - dc;
						}
                        left++;
                    } else {
                    	int dc = sum - twoSum;
                    	if (dc < distance) {
							distance = dc;
							ans = twoSum + dc;
						}
                        right--;
                    }
                }
            
        }
        
        return ans;
    }
}
