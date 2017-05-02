package com.mv.leetCode;

import java.util.LinkedList;

public class SimplifyPath {

	public String simplifyPath(String path) {
		LinkedList<Character> stack = new LinkedList<>();
		int pos = 0;
		while (pos < path.length()) {
			char c = path.charAt(pos);
			if (c == '/') {
				if (pos + 3 < path.length() && path.charAt(pos + 1) == '.' && path.charAt(pos + 2) == '.' && path.charAt(pos+3) == '/') {
					while (!stack.isEmpty() && stack.removeLast() != '/')
						;
					pos = pos + 3;
				} else if (pos + 2 < path.length() && path.charAt(pos + 1) == '.' && path.charAt(pos + 2) == '/') {
					pos = pos + 2;
				} else if(pos + 1 < path.length() && path.charAt(pos + 1) == '/'){
					while(pos < path.length() && path.charAt(pos) == '/') {
						pos++;
					}
					stack.add('/');
				}
				else {
					stack.add(c);
					pos++;
				}
			} else {
				stack.add(c);
				pos++;

			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		
		
		while (sb.length() > 1 && ((sb.charAt(sb.length() - 1) == '/') || sb.charAt(sb.length() - 1) == '.'))
			sb.deleteCharAt(sb.length() - 1);
		if(sb.length() == 0) return "/";
		return sb.toString();

	}

}
