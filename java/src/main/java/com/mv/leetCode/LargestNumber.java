package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) return "";
		Comparator<String> cmp = (e1, e2) -> {
			String s1 = e1 + e2;
			String s2 = e2 + e1;
			return 0 - s1.compareTo(s2);
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
