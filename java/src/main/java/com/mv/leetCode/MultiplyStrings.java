package com.mv.leetCode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if(num1 == null || num2 == null) return "";
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		char[] c1 = num1.toCharArray();
		char[] c2 = num2.toCharArray();

		int M = num1.length();
		int N = num2.length();
		int[] ans= new int[M + N];
		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				ans[M+N-i-j-2] += (c1[i] - '0') * (c2[j] -'0');
				ans[M+N-i-j-1] += ans[M+N-i-j-2] / 10;
				ans[M+N-i-j-2] %= 10;
			}
		}
		
		//build ans string
		StringBuilder result = new StringBuilder();
		for (int i = M + N - 1; i >= 0; i--) {
			if(ans[i] != 0) {
				for (int j = i; j >= 0; j--) {
					result.append(ans[j]);
				}
				return result.toString();
			}
		}
		return "0";
	}

}
