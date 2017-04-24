package com.mv.leetCode;

import static org.mockito.Matchers.contains;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
    	Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
		int minL = Integer.MAX_VALUE;
		int maxL = Integer.MIN_VALUE;
		for(String str: dict) {
			minL = str.length() < minL ? str.length() : minL;
			maxL = str.length() > maxL ? str.length() : maxL;
		}
        boolean[] dp = getDp(s, dict, minL, maxL);
        if(!dp[0]) return ans;
        for (int i = minL; i <= maxL; i++) {
			if(i < dp.length && dp[i] && dict.contains(s.substring(0, i)))
				dfs(dp, dict, ans, s.substring(0, i), i, minL, maxL, s);
		}
        return ans;
    }

	private void dfs(boolean[] dp, Set<String> dict, List<String> ans, String sb, int pos, int minL, int maxL, String s) {
		if(pos == dp.length - 1) {
			ans.add(sb);
			return;
		}
		for (int i = minL; i <= maxL; i++) {
			if(pos + i < dp.length && dp[pos + i]) {
				String str = s.substring(pos, pos + i);
				if(dict.contains(str))
					dfs(dp, dict, ans, sb+" " + str, pos+i, minL, maxL, s);
			}
		}
		
	}

	private boolean[] getDp(String s, Set<String> dict, int minL, int maxL) {
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
		return dp;
	}

}
