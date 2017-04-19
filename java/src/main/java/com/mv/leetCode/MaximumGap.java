package com.mv.leetCode;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            ans = Math.max(nums[i] - nums[i-1], ans);
        }
        
        return ans;
    }

}
