package com.mv.leetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int ans = 0;
        while(low < high) {
            ans = Math.max(Math.min(height[low], height[high]) * (high - low), ans);
            if(height[low] < height[high]) {
                int currLowHeight = height[low];
                while(low < high && height[low] <= currLowHeight) {
                    low++;
                } 
            } else {
                int currHighHeight = height[high];
                while(low < high && height[high] <= currHighHeight) {
                    high--;
                } 
            }
        }
        return ans;
    }
}
