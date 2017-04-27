package com.mv.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        List<String> item = new ArrayList<>();
    	if(s == null || s.isEmpty()) return ans;
        iterate(s, ans, item, 0);
        return ans;
    }

	private void iterate(String s, List<List<String>> ans, List<String> item, int begin) {
		if(begin == s.length()) {
			ans.add(new ArrayList<>(item));
			return;
		}
		int pos = begin + 1;
		while(pos <= s.length()) {
			if(isPalindrome(s, begin, pos-1)) {
				item.add(s.substring(begin, pos));
				iterate(s, ans, item, pos);
				item.remove(item.size() - 1);
			}
			pos++;
		}
	}

	private boolean isPalindrome(String s, int begin, int end) {
		while(begin <= end) {
			if(s.charAt(begin) != s.charAt(end)) return false;
			begin++;
			end--;
		}
		return true;
	}
    
}
