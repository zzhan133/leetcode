package com.mv.leetCode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if(nums.length == 1) {
        	return nums[0];
        }
        
        int beginIndex = 0;
        while(beginIndex < nums.length && nums[beginIndex] == 0) {
        	beginIndex++;
        	ans = 0;
        }
        
        if(beginIndex == nums.length) {
        	return 0;
        }
        
        int endIndex = nums.length - 1;
        while(endIndex > beginIndex && nums[endIndex] == 0) {
        	endIndex--;
        	ans = 0;
        }
        
        if(beginIndex == endIndex) {
        	return Math.max(0, nums[beginIndex]);
        }
        
        int low = beginIndex;
        int high = low;
        
        for (int i = beginIndex; i < endIndex; i++) { //nums[endIndex] != 0
        	if(nums[i] == 0){
        		int cur_max = maxProductWithoutZero(nums, low, high);
        		cur_max = cur_max < 0 ? 0 : cur_max;
        		ans = Math.max(ans, cur_max);
        		while(i < nums.length && nums[i] == 0) {
        			i++;
        		}
        		if(i != nums.length) {
        			low = i;
        		}
        	} else {
				high = i;
			}
		}
        
        int lastSession = maxProductWithoutZero(nums, low, endIndex);
        return Math.max(ans, lastSession);
    }
    
    private int maxProductWithoutZero(int[] nums, int low, int high) {
    	if(low == high) {
    		return nums[low];
    	}
    	int count = 0;
    	for (int i = low; i <= high; i++) {
			if(nums[i] < 0) {
				count++;
			}
		}
    	if(count % 2 == 1) {
    		int firstNegPos = 0;
    		int lastNegPos = 0;
    		for (int i = low; i <= high; i++) {
				if(nums[i] < 0) {
					firstNegPos = i;
					break;
				}
			}
    		
    		for (int i = high; i >= low; i--) {
				if(nums[i] < 0) {
					 lastNegPos = i;
					 break;
				}
			}
    		return Math.max(productRange(nums, low, lastNegPos - 1), productRange(nums, firstNegPos+1, high));
    	} else {
    		return productRange(nums, low, high);
    	}
    	
    	
    }

	private int productRange(int[] nums, int low, int high) {
		int proc = 1;
		for (int j = low; j <= high; j++) {
			proc = proc * nums[j];
		}
		return proc;
	}

}
