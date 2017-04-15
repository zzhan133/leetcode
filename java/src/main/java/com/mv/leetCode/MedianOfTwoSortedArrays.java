package com.mv.leetCode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    	int n = nums1.length;
    	int m = nums2.length;
    	if(n > m) return findMedianSortedArrays1(nums2, nums1);
    	final int k = (n + m - 1) / 2; // mid position;
    	int l = 0, r = Math.min(k, n);
    	while (l < r) {
    		int mid1 = l + (r - 1) / 2;
    		int mid2 = k - mid1;
    		if(nums1[mid1]  < nums2[mid2]) {
    			l = mid1 + 1;
    		} else {
    			r = mid1;
    		}
		}
    	int a = Math.max(l > 0 ? nums1[l-1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k-l] : Integer.MIN_VALUE);
    	if((n+m) %2 == 1) {
    		return (double) a;
    	}
    	
    	int b = Math.min(l<n ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < m ? nums2[k-l+1] : Integer.MAX_VALUE);
    	return (a + b) / 2.0;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int length1 = nums1.length;
    	int length2 = nums2.length;
    	if (length1 > length2) return findMedianSortedArrays(nums2, nums1);
    	if ((length1 + length2) % 2 == 1) {
    		return (double)findKthElem(nums1, 0, nums2, 0, (length1 + length2) / 2 + 1);
    	} else {
    		return (findKthElem(nums1, 0, nums2, 0, (length1 + length2) / 2 ) + 
    				findKthElem(nums1, 0, nums2, 0, (length1 + length2) / 2 + 1)) / 2.0;
    	}
    }
    
    private int findKthElem(int[] nums1, int low1, int[] nums2, int low2, int k) {
    	if(low1 >= nums1.length) {
    		return nums2[low2 + k - 1];
    	}
    	if(low2 == nums2.length) {
    		return nums1[low1 + k - 1];
    	}
    	if(k == 1) {
    		return Math.min(nums1[low1], nums2[low2]);
    	}
    	int distance = k/2 - 1;
    	int md1Value = low1 + distance < nums1.length ?  nums1[low1 + distance] : Integer.MAX_VALUE;
    	int md2Value = nums2[low2 + distance];
    	if(md1Value < md2Value) {
    		return findKthElem(nums1, low1 + k / 2, nums2, low2, k - k/2);
    	} else {
    		return findKthElem(nums1, low1, nums2, low2 + k / 2, k - k/2);
    	}
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
    	double md1Value = singleArrayMedian(nums1, low1, high1);
    	double md2Value = singleArrayMedian(nums2, low2, high2);
    	if(md1Value > md2Value) {
    		int distance = high1 - md1;
    		return findMedianWithIndex(nums1, low1, md1, nums2, low2 + distance, high2);
    	} else if(md1Value < md2Value) {
    		int distance = md1 - low1 + 1;
    		return findMedianWithIndex(nums1, md1 + 1, high1, nums2, low2, high2 - distance);
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
