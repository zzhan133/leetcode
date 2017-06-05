package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) return "";
		Comparator<String> cmp = (e1, e2) -> {
			int length = e1.length() > e2.length() ? e1.length() : e2.length();
			int pos = 0;
			char c1 = '0';
			char c2 = '0';
			while (pos < length) {
				c1 = pos >= e1.length() ? e2.charAt(pos-e1.length()) : e1.charAt(pos);
				c2 = pos >= e2.length() ? e1.charAt(pos-e2.length()) : e2.charAt(pos);
				if(c1 > c2) return -1;
				else if(c1 < c2) return 1;
				pos++;
			}
			return 0;
		};
		List<String> strs = new ArrayList<>(); 
		for(int elem: nums) {
			strs.add(String.valueOf(elem));
		}
		strs.sort(cmp);
		int unZeroPos = 0;
		while (unZeroPos < strs.size()) {
			if (strs.get(unZeroPos).equals("0")) {
				unZeroPos++;
			} else {
				break;
			}
				
		}
		if (unZeroPos == strs.size()) return "0";
		StringBuilder sb = new StringBuilder();
		for(int i = unZeroPos; i < strs.size(); i++) {
			sb.append(strs.get(i));
		}
		return sb.toString();
	}

}
