package com.mv.leetCode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k <= 0 || k >= nums.length) {
            return;
        }
        int tmp[] = new int[k];
        for(int i = 0 ; i < k; i++ ){
            tmp[i] = nums[nums.length - i -1];
        }
        for(int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for(int i = 0; i< k; i++) {
            nums[k - i - 1] = tmp[i];
        }
    }

}
