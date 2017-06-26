package com.amazon.leetCode;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String prev = "1";
        int walker = 1;
        while( walker < n) {
        	String cur = getCur(prev);
        	prev = cur;
            walker++;
        }
        return prev;
    }

	private String getCur(String prev) {
		StringBuilder sb = new StringBuilder();
		int walker = 0;
		while(walker < prev.length()) {
			int count = getCount(prev, walker);
			sb.append(count);
			char c = prev.charAt(walker);
			sb.append(c);
			walker = walker + count;
		}
		return sb.toString();
	}

	private int getCount(String prev, int walker) {
		char c = prev.charAt(walker);
		int count = 0;
		while(walker < prev.length()) {
			if(prev.charAt(walker) != c) {
				break;
			}
			count++;
			walker++;
		}
		return count;
	}
}
