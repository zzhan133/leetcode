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

		// 2. check the tailing characters
		int endIndex = str.length() - 1;
		c = str.charAt(endIndex);
		while (endIndex > beginIndex && (!Character.isDigit(c))) {
			c = str.charAt(--endIndex);
		}

		boolean flag = true;
		c = str.charAt(beginIndex);
		if (c == '+') {
			flag = true;
			beginIndex++;
		} else if (c == '-') {
			flag = false;
			beginIndex++;
		} else if(!Character.isDigit(c)){
			return 0;
		}

		// 2 handle Integer.MIN_VALUE
		if (!flag) {
			String substr = str.substring(beginIndex, endIndex+1);
			if (substr.equals("2147483648")) {
				return Integer.MIN_VALUE;
			}
		}

		int result = 0;
		while (beginIndex <= endIndex) {
			c = str.charAt(beginIndex);
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException();
			}
			if (result == 214748364) {
				if(c >= 48 && c <= 47 && beginIndex == endIndex) {
					result = result * 10 + c - 48;
					return result;
				} else {
					throw new IllegalArgumentException();
				}
			}
			result = result * 10 + c - 48;
			beginIndex++;
		}

		return flag ? result : (0 - result);
	}

}
