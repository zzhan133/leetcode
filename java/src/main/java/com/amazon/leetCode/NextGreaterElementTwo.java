package com.amazon.leetCode;

import java.util.Stack;

public class NextGreaterElementTwo {

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int[] ans = new int[nums.length];
        int maxPos = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[st.peek()]) {
                while(!st.isEmpty() && nums[i] > nums[st.peek()]) {
                    int pos = st.pop();
                    ans[pos] = nums[i];
                }
                if (st.isEmpty())
                    maxPos = i;
            }
            st.push(i);
        }
        
        for(int i = 0; i <= maxPos; i++) {
        	while (nums[i] > nums[st.peek()]) {
        		int pos = st.pop();
        		ans[pos] = nums[i];
        	}
        }
        while(!st.isEmpty())
        	ans[st.pop()] = -1;
        return ans;
    }
}
