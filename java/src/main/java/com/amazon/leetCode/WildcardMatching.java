package com.amazon.leetCode;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		if (s == null)
			return true;
		if (p == null)
			return false;
		p = process(p);
		return isMatch(s, 0, p, 0);
	}

	private String process(String p) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*') {
				if (i > 0 && p.charAt(i - 1) == '*') {
					continue;
				} else {
					sb.append(p.charAt(i));
				}
			} else {
				sb.append(p.charAt(i));
			}
		}
		return p.toString();
	}

	private boolean isMatch(String s, int sPos, String p, int pPos) {
    	if(pPos == p.length() && sPos == s.length()) {
    		return true;
    	} else if (sPos == s.length()) {
    		if(pPos == p.length() - 1 && p.charAt(pPos) == '*')
    			return true;
    		else
    			return false;
    	} else if(pPos == p.length()) {
    		return false;
    	} else {
    		if(p.charAt(pPos) == '*') {
    			return isStarMatch(s, sPos, p, pPos);
    		} else if (p.charAt(pPos) == '?') {
    			return isMatch(s, sPos+1, p, pPos +1);
    		} else {
    			if(s.charAt(sPos) == p.charAt(pPos)) {
    				return isMatch(s, sPos + 1, p, pPos + 1);
    			} else 
    				return false;
    		}
    	}
    }

	// p.charAt(pPos) == '*'
	private boolean isStarMatch(String s, int sPos, String p, int pPos) {
		int remainning = p.length() - pPos - 1;
		if (remainning == 0)
			return true;
		if(isMatch(s, sPos, p, pPos+1))
			return true;
		for (int i = s.length() - remainning; i >= sPos; i--) {
			if (isMatch(s, i, p, pPos + 1))
				return true;
		}
		return false;
	}

}
