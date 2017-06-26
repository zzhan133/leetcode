package com.amazon.leetCode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if(s == null || s.equals("") || s.length() == 1) return s;
    	String ans = s.substring(0, 1);
    	for (int i = 1; i <s.length() - 1; i++) {
			String tmp = singlePalin(s, i);
			if(tmp.length() > ans.length()) {
				ans = tmp;
			}
		}
    	
    	for(int i = 1; i < s.length(); i++) {
    		if(s.charAt(i) == s.charAt(i-1)) {
    			String tmp = evenPalin(s, i);
    			if(tmp.length() > ans.length()) {
    				ans = tmp;
    			}
    		}
    	}
        return ans;
    }

	private String evenPalin(String s, int i) {
		String ans = "";
		int left = i - 1;
		int right = i;
		while(left >= 0 && right < s.length()) {
			if(s.charAt(left) != s.charAt(right)) {
				ans = s.substring(left + 1, right);
				break;
			}
			left--;
			right++;
		}
		if(left == -1) {
			ans = s.substring(0, right);
		} else if(right == s.length()) {
			ans = s.substring(left + 1);
		}
		return ans;
	}

	private String singlePalin(String s, int centerIndex) {
		int left = centerIndex - 1;
		int right = centerIndex + 1;
		String ans = "";
		while(left >= 0 && right < s.length()) {
			if(s.charAt(left) != s.charAt(right)) {
				ans = s.substring(left+1, right);
				break;
			}
			left--;
			right++;
		}
		if(left == -1) {
			ans = s.substring(0, right);
		} else if(right == s.length()) {
			ans = s.substring(left + 1);
		}
		return ans;
	}

}
