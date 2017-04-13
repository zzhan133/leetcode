package com.mv.leetCode;

public class Atoi {
	public int myAtoi(String str) {
		// 1. find valid starting number
		if (str == null || str.length() == 0) {
			return 0;
		}

		int beginIndex = 0;
		char c = str.charAt(beginIndex);
		while (beginIndex < str.length() && Character.isWhitespace(c)) {
			c = str.charAt(++beginIndex);
		}

		if (beginIndex == str.length()) {
			return 0;
		}

		boolean flag = true;
		c = str.charAt(beginIndex); // the first no-space char
		if (c == '+') {
			flag = true;
			beginIndex++;
		} else if (c == '-') {
			flag = false;
			beginIndex++;
		} else if (!Character.isDigit(c)) {
			return 0;
		}

		if (beginIndex == str.length() || !Character.isDigit(str.charAt(beginIndex))) {
			return 0;
		}

		// 2. check the tailing characters
		int endIndex = beginIndex;
		while (endIndex < str.length() && Character.isDigit(str.charAt(endIndex))) {
			endIndex++;
		}

		long result = 0;
		while (beginIndex < endIndex) {
			c = str.charAt(beginIndex);
			result = result * 10 + c - 48;
			if(result > Integer.MAX_VALUE) {
				if(flag) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			beginIndex++;
		}
		
		int ans = (int)result;
		return flag ? ans : (0-ans);
	}

}
