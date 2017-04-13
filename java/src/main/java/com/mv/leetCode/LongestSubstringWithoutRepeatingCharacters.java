package com.mv.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		if(s == null || s.length() == 0) {
			return ans;
		}
		int beginIndex = 0;
		Map<Character, Integer> charPos = new HashMap<>();
		for (int i = 0; i< s.length(); i++) {
			char c = s.charAt(i);
			if(!charPos.containsKey(c) || charPos.get(c) < beginIndex) {
				charPos.put(c, i);
			} else {
				ans = Math.max(i - beginIndex, ans);
				beginIndex = charPos.get(c) + 1;
				charPos.put(c, i);
			}
		}
		
		return Math.max(s.length() - beginIndex, ans);
	}

}
