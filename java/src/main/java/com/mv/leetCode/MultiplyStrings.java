package com.mv.leetCode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		if(num1.equals("1")) {
			return num2;
		}
		if(num2.equals("1")) {
			return num1;
		}
		if(num1.length() > num2.length()) {
			return multiply(num2, num1);
		}
		boolean isEven = (num1.charAt(num1.length() - 1) - '0') % 2 == 0;
		if(isEven) {
			return multiply(divide2(num1), multiply2(num2)); 
		} else {
			return add(num2, multiply(divide2(num1), multiply2(num2))); 
		}
	}

	public String add(String shorterNum, String num2) {
		StringBuilder sb = new StringBuilder();
		int addOne = 0;
		for (int i = num2.length() - 1; i >= 0; i--) {
			int distance = num2.length() - i;
			int firstIndex = shorterNum.length()-distance;
			int first = (firstIndex < 0) ? 0 : shorterNum.charAt(firstIndex) - '0';
			int second = num2.charAt(i) - '0';
			int sum = first + second + addOne;
			addOne = sum > 9 ? 1 : 0;
			sb.insert(0, (char)(sum % 10 + '0'));
		}
		if(addOne == 1) {
			sb.insert(0, '1');
		}
		return sb.toString();
	}

	public String divide2(String num1) {
		StringBuilder sb = new StringBuilder();
		int addTen = 0;
		for (int i = 0; i < num1.length(); i++) {
			int num = num1.charAt(i) - '0' + addTen;
			if(num < 2) {
				if(sb.length() > 0) {
					sb.append('0');
				}
				addTen = 10;
			} else {
				sb.append((char)(num / 2 + '0'));
				if(num % 2 == 1) {
					addTen = 10;
				} else {
					addTen = 0;
				}
			}
			
		}
		return sb.toString();
	}

	public String multiply2(String nums1) {
		StringBuilder sb = new StringBuilder();
		int addOne = 0;
		for (int i = nums1.length() - 1; i >= 0; i--) {
			int num = (nums1.charAt(i) - '0') * 2;
			char c = (char) ((num % 10 + addOne) + '0');
			sb.insert(0, c);
			addOne = num > 9 ? 1 : 0;
		}
		if(addOne == 1) {
			sb.insert(0, '1');
		}
		
		return sb.toString();
	}
}
