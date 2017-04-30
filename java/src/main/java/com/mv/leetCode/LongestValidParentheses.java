package com.mv.leetCode;

import java.util.Stack;

//"()(()"
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1)
			return 0;
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		int ptrPos = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					ptrPos = i+1;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						ans = Math.max(ans, i - ptrPos + 1);
					} else {
						int length = i - stack.peek();
						ans = Math.max(ans, length);
					}
				}
			}

		}
		return ans;
	}

}
