package com.mv.leetCode;

import java.util.Arrays;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
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

		if (s1.charAt(0) == s3.charAt(0)) {
			if(s3 == s1 + s2) {
				return true;
			}

			boolean ans = isInterleaveStartsWith(s1, s2, 1, s3, 1, "");
			if (ans) {
				return true;
			}
		}
		if (s2.charAt(0) == s3.charAt(0)) {
			if (isInterleaveStartsWith(s2, s1, 1, s3, 1, "")) {
				return true;
			}
		}
		return false;
	}

	private boolean isInterleaveStartsWith(String s1, String s2, int posS1, String s3, int posS3, String str) {
		if (posS1 == s1.length()) {
			return s3.substring(posS3).equals(s2.substring(0 + str.length()));
		}
		char cS1 = s1.charAt(posS1);
		while (posS3 < s3.length()) {
			if (s3.charAt(posS3) == cS1) {
				if (s2.startsWith(str)) {
					if (isInterleaveStartsWith(s1, s2, posS1 + 1, s3, posS3 + 1, str)) {
						return true;
					}
				} else {
					return false;
				}
			} else {
				str = str + s3.charAt(posS3);
			}
			posS3++;
		}
		return false;
	}

}
