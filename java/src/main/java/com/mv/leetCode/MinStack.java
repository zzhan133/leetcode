package com.mv.leetCode;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
	
	private Stack<Integer> values;
	private Stack<Integer> minV;
	
    public MinStack() {
        values = new Stack<>();
        minV = new Stack<>();
    }
    
    public void push(int x) {
        values.push(x);
        if(minV.isEmpty() || x <= minV.peek()){
            minV.push(x);
        }
    }
    
    public void pop() {
        int value = values.pop();
        if(value == minV.peek()) {
        	minV.pop();
        }
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return minV.peek();
    }
}