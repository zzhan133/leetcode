package com.mv.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderTwo {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
		Set<String> wordSet = new HashSet<>(wordList);
		if(!wordSet.contains(endWord)) return ans;
		Map<String, Set<String>> graph = new HashMap<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		Queue<String> nextLevel = new LinkedList<>();
		queue.add(beginWord);
		visited.add(beginWord);
		
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				String str = queue.remove();
				char c = 'a';
				while (c <= 'z') {
					for (int i = 0; i < str.length(); i++) {
						StringBuilder sb = new StringBuilder(str);
						if(c == sb.charAt(i)) continue;
						sb.setCharAt(i, c);
						String trans = sb.toString();
						if(trans.equals(endWord)){
							if(!graph.containsKey(endWord)) {
								Set<String> connected = new HashSet<>();
								graph.put(endWord, connected);
							}
							graph.get(endWord).add(str);
						}
						else if (wordSet.contains(trans) && !visited.contains(trans)) {
							nextLevel.add(trans);
							if(!graph.containsKey(trans)) {
								Set<String> connected = new HashSet<>();
								graph.put(trans, connected);
							}
							graph.get(trans).add(str);
						}
					}
					c += 1;
				}
			}
			if(graph.containsKey(endWord)){
				break;
			}
			visited.addAll(nextLevel);
			queue = nextLevel;
			nextLevel = new LinkedList<>();

		}
		if(!graph.containsKey(endWord)) {
			return ans;
		}
		LinkedList<String> path = new LinkedList<>();
		path.add(endWord);
		getPath(ans, graph, endWord, path);
        return ans;
    }

	private void getPath(List<List<String>> ans, Map<String, Set<String>> graph, String endWord, LinkedList<String> path) {
		Set<String> nextPoints = graph.get(endWord);
		if (nextPoints == null || nextPoints.isEmpty()) {
			ans.add(new ArrayList<String>(path));
			return;
		}
		
		for(String nextStop: nextPoints) {
			path.addFirst(nextStop);
			getPath(ans, graph, nextStop, path);
			path.remove(0);
		}
	}

}
