package com.amazon.leetCode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        
        int pos = 0;
        int tmp = 0;
        while(pos < k) {
            tmp = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= 0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = tmp;
            pos++;
        }
    }

}
