package com.mv.leetCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x == Integer.MIN_VALUE) return false;
		x = Math.abs(x);
		int high = 1;
		while (x / high >= 10) {
			high = high * 10;
		}

		int low = 1;

		while (high > low) {
			int highValue = (x / high) % 10;
			int lowValue = (x / low) % 10;
			if (highValue != lowValue) {
				return false;
			}
			high = high / 10;
			low = low * 10;
		}

		return true;
	}

}
