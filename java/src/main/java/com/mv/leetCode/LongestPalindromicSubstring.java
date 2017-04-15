package com.mv.leetCode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
        	return s;
        }
        
        String ans = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
        	String singleCenter = center(s, i, i);
        	String doubleCenter = center(s, i, i+1);
        	String tmp = singleCenter.length() > doubleCenter.length() ? singleCenter : doubleCenter;
        	ans = ans.length() < tmp.length() ? tmp : ans;
		}
        return ans;
    }

	private String center(String s, int i, int i2) {
		int low = i;
		int high = i2;
		while ( low >= 0 && high < s.length()) {
			if(s.charAt(low) == s.charAt(high)){
				low--;
				high++;
			} else {
				break;
			}
		}
		
		if(low < 0) {
			return s.substring(0, high);
		}
		if(high == s.length()) {
			return s.substring(low + 1);
		}		
		return s.substring(low + 1, high);
	}
    
    
}
