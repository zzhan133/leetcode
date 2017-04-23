package com.mv.leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		if(!wordSet.contains(endWord)) return 0;
		Set<String> visited = new HashSet<>();
		int ans = 1;
		Queue<String> queue = new LinkedList<>();
		Queue<String> nextLevel = new LinkedList<>();
		queue.add(beginWord);
		
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				String str = queue.remove();
				char c = 'a';
				while (c <= 'z') {
					for (int i = 0; i < str.length(); i++) {
						StringBuilder sb = new StringBuilder(str);
						sb.setCharAt(i, c);
						String trans = sb.toString();
						if(trans.equals(endWord)){
							return ++ans;
						}
						if (wordSet.contains(trans) && !visited.contains(trans)) {
							nextLevel.add(trans);
							visited.add(trans);
						}
					}
					c += 1;
				}
			}
			queue = nextLevel;
			nextLevel = new LinkedList<>();
			ans++;

		}
		return 0;
	}
}
