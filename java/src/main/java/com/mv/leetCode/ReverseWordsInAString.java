package com.mv.leetCode;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		String[] arr = s.split(" ");
		if (arr == null || arr.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (!arr[i].equals("")) {
				sb.append(" ");
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}

}
