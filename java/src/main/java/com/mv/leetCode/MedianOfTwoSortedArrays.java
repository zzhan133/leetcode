package com.mv.leetCode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(nums1 == null && nums2 == null) {
    		return 0;
    	}
    	if(nums1 == null || nums1.length == 0) {
    		return singleArrayMedian(nums2, 0, nums2.length - 1);
    	}
    	if(nums2 == null || nums2.length == 0) {
    		return singleArrayMedian(nums1, 0, nums1.length - 1);
    	}
    	
    	int[] minLength = nums1.length < nums2.length ? nums1 : nums2;
    	int[] maxLength = nums1.length >= nums2.length ? nums1 : nums2;
        
    	return findMedianWithIndex(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }

	private double findMedianWithIndex(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2) {
    	if (low1 == high1 && low2 == high2) {
			return (nums1[low1] + nums2[low2]) / 2.0;
		}
    	if(low1 == high1) {
    		return findMedian(nums1[low1], nums2, low2, high2);
    	}
    	if(low2 == high2){
    		return findMedian(nums2[low2], nums1, low1, high1);
    	}
    	int md1 = (low1 + high1)/2;
    	int md2 = (low2 + high2)/2;
    	double md1Value = singleArrayMedian(nums1, low1, high1);
    	double md2Value = singleArrayMedian(nums2, low2, high2);
    	if(md1Value > md2Value) {
    		return findMedianWithIndex(nums1, low1, md1, nums2, md2 + 1, high2);
    	} else if(md1Value < md2Value) {
    		return findMedianWithIndex(nums1, md1 + 1, high1, nums2, low2, md2);
    	} else {
    		return md1Value;
    	}
    }
	
    private double singleArrayMedian(int[] nums, int low, int high) {
		if(nums == null || nums.length == 0) {
			return 0;
		} else {
			int length = high - low + 1;
			int middle = (high + low) / 2;
			if (length % 2 == 1) {
				return nums[middle];
			} else {
				return (nums[middle] + nums[middle + 1]) / 2.0; 
			}
		}
	}


	private double findMedian(int singleValue, int[] nums, int low, int high) {
		int middle = (low + high) / 2;
		if((high - low + 1) % 2 == 1) {
			if(singleValue <= nums[middle - 1]) {
				return (nums[middle-1] + nums[middle])/2.0;
			} else if(singleValue > nums[middle - 1] && singleValue < nums[middle + 1]){
				return (nums[middle] + singleValue) / 2.0;
			} else {
				return (nums[middle+1] + nums[middle])/2.0;
			}
		} else {
			if(singleValue >= nums[middle] && singleValue <= nums[middle + 1]) {
				return singleValue;
			} else if(singleValue <= nums[middle]){
				return nums[middle];
			} else {
				return nums[middle + 1];
			}
		}
	}
}
