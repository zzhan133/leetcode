package com.mv.leetCode;

public class Atoi {
	public int myAtoi(String str) {
		// 1. find valid starting number
		if (str == null || str.length() == 0) {
			return 0;
		}

		int beginIndex = 0;
		char c = str.charAt(beginIndex);
		while (beginIndex < str.length() && (c == ' ' || c == '\n' || c == '\r' || c == '\t')) {
			c = str.charAt(++beginIndex);
		}

		if (beginIndex == str.length()) {
			return 0;
		}

		boolean flag = true;
		c = str.charAt(beginIndex);  //the first no-space char
		if (c == '+') {
			flag = true;
			beginIndex++;
		} else if (c == '-') {
			flag = false;
			beginIndex++;
		} else if(!Character.isDigit(c)){
			return 0;
		}
		
		if(beginIndex == str.length() || !Character.isDigit(str.charAt(beginIndex))) {
			return 0;
		}
		
		// 2. check the tailing characters
		int endIndex = beginIndex;
		while (endIndex < str.length() && Character.isDigit(str.charAt(endIndex))) {
			endIndex++;
		}
		
		int result = 0;
		while (beginIndex < endIndex) {
			c = str.charAt(beginIndex);
			if (result >= 214748364) {
				if((c >= 48 && c <= 55) && result / 10 < 100000000) {
					result = result * 10 + c - 48;
				} else {
					if(flag) {
						return Integer.MAX_VALUE;
					} else {
						return Integer.MIN_VALUE;
					}
				}
			} else {
				result = result * 10 + c - 48;
			}
			beginIndex++;
		}

		return flag ? result : (0 - result);
	}

}
