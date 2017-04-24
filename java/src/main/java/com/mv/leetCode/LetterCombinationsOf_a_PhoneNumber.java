package com.mv.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOf_a_PhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> ans = new LinkedList<>();
		if (digits == null || digits.isEmpty()) {
			return ans;
		}
		Character[] a2 = { 'a', 'b', 'c' };
		Character[] a3 = { 'd', 'e', 'f' };
		Character[] a4 = { 'g', 'h', 'i' };
		Character[] a5 = { 'j', 'k', 'l' };
		Character[] a6 = { 'm', 'n', 'o' };
		Character[] a7 = { 'p', 'q', 'r', 's' };
		Character[] a8 = { 't', 'u', 'v' };
		Character[] a9 = { 'w', 'x', 'y', 'z' };
		Map<Character, List<Character>> maps = new HashMap<>();
		maps.put('0', new ArrayList<>());
		maps.put('1', new ArrayList<>());
		maps.put('2', Arrays.asList(a2));
		maps.put('3', Arrays.asList(a3));
		maps.put('4', Arrays.asList(a4));
		maps.put('5', Arrays.asList(a5));
		maps.put('6', Arrays.asList(a6));
		maps.put('7', Arrays.asList(a7));
		maps.put('8', Arrays.asList(a8));
		maps.put('9', Arrays.asList(a9));
		combinations(ans, digits, maps, 0, "");
		return ans;
	}

	private void combinations(List<String> ans, String digits, Map<Character, List<Character>> maps, int pos, String str) {
		if(pos == digits.length()) {
			ans.add(str);
			return;
		}
		
		List<Character> letters = maps.get(digits.charAt(pos));
		for (Character c: letters) {
			combinations(ans, digits, maps, pos + 1, str + c);
		}
	}


}
