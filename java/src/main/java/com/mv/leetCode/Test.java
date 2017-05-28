package com.mv.leetCode;

import java.util.Arrays;

public class Test {
    public void nextPermutation(int[] nums) {
        int pos = nums.length - 2;
        while (pos >= 0 && nums[pos] >= nums[pos + 1] ) {
            pos--;
        }
        
        if (pos == -1) {
            reverse(nums, 0);
            return;
        }
        
        int newPos = findPos(nums, nums[pos], pos + 1);
        System.out.println("new Pos: " + newPos);
        int tmp = nums[newPos];
        nums[newPos] = nums[pos];
        nums[pos] = tmp;
        reverse(nums, pos+1);
        
    }
    
    private int findPos (int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            if(nums[middle] <= target) {
                right = middle - 1;
            } else {
                if(nums[middle + 1] <= target)
                    return middle;
                left = middle + 1;
            }
        }
        
        return left;
    }
    
    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    
    public static void main(String[] args) {
		Test obj = new Test();
		int[] nums = {2,3,1};
		obj.nextPermutation(nums);
		System.out.println(Arrays.asList(nums));
	}
}
