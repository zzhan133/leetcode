package com.mv.leetCode;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int lastAscPos = 0;
		int i = nums.length - 1;
		for (; i > 0; i--) {
			if(nums[i] > nums[i-1]){
				lastAscPos = i - 1;
				break;
			}
		}
		if(i == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int nextPos = nextGreaterPos(nums, lastAscPos + 1, nums[lastAscPos]);
		int tmp = nums[lastAscPos];
		nums[lastAscPos] = nums[nextPos];
		nums[nextPos] = tmp;
		reverse(nums, lastAscPos+1, nums.length - 1);
		
	}
	
	private int nextGreaterPos(int[] nums, int left, int target) {
		int low = left;
		int high = nums.length - 1;
		while(low < high) {
			int mid = (low + high) / 2;
			int midV = nums[mid];
			if(midV <= target) {
				high = mid - 1;
			} else {
				if(nums[mid + 1] > target) 
					low = mid + 1;
				else 
					return mid;
			}
		}
		return low;
	}
	
	private void reverse(int[] nums, int left, int right) {
		while(left < right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;
		}
	}
}
