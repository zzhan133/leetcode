package com.mv.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int minL = Integer.MAX_VALUE;
		int maxL = Integer.MIN_VALUE;
		for (String str : wordDict) {
			minL = str.length() < minL ? str.length() : minL;
			maxL = str.length() > maxL ? str.length() : maxL;
		}
		Set<String> dict = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[s.length()] = true;

		for (int i = s.length() - minL; i >= 0; i--) {
			for (int j = minL; j <= maxL; j++) {
				String curr = null;
				if (i + j <= s.length()) {
					curr = s.substring(i, i+j);
					if (dict.contains(curr) && dp[i + j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[0];
	}
}
