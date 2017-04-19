package com.mv.leetCode;

import java.util.Arrays;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}

		String tmp = s1 + s2;
		char[] combine = tmp.toCharArray();
		Arrays.sort(combine);
		char[] s3Array = s3.toCharArray();
		Arrays.sort(s3Array);
		if (!(new String(combine).equals(new String(s3Array)))) {
			return false;
		}

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = true;
				}
				else if(i == 0) {
					dp[i][j] = dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(j - 1);
				}
				else if(j == 0 ) {
					dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i-1][j];
				}
 				else if(s1.charAt(i-1) == s3.charAt(i + j - 1) && 
						s2.charAt(j-1) != s3.charAt(i +j -1)) {
					dp[i][j] = dp[i-1][j];
				} else if (s1.charAt(i - 1) != s3.charAt(i + j - 1) &&
						s2.charAt(j-1) == s3.charAt(i+j-1)) {
					dp[i][j] = dp[i][j-1];
					
				} else if(s1.charAt(i - 1) == s3.charAt(i + j - 1) &&
						s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
//	for (int i = 0; i < dp.length; i++) {
//		for (int j = 0; j < dp[0].length; j++) {
//			System.out.print(dp[i][j] + ",");
//		}
//		System.out.println();
//	}
}
