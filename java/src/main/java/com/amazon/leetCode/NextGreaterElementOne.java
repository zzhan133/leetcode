package com.amazon.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementOne {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        if(findNums == null || findNums.length == 0) return new int[0];
        int[] ans = new int[findNums.length];
        stack.push(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > stack.peek()) {
                int val = stack.peek();
                while(!stack.isEmpty() && val < nums[i]) {
                    map.put(stack.pop(), nums[i]);
                    if(!stack.isEmpty())
                    	val = stack.peek();
                }
                stack.push(nums[i]);
            } else {
                stack.push(nums[i]);
            }
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        
        for(int i = 0; i < findNums.length; i++) {
            ans[i] = map.get(findNums[i]);
        }
        return ans;
    }

}
