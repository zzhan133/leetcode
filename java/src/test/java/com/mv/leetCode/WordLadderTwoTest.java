package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordLadderTwoTest {

	private WordLadderTwo obj  = new WordLadderTwo();

	@Test
	public void testLadderLength() throws Exception {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		
		assertEquals(2, obj.findLadders(beginWord, endWord, wordList).size());
	}
	
	@Test
	public void testLadderLength1() throws Exception {
		String beginWord = "a";
		String endWord = "c";
		List<String> wordList = new ArrayList<>(Arrays.asList("a","b","c"));
		
		assertEquals(1, obj.findLadders(beginWord, endWord, wordList).size());
	}
	
	@Test
	public void testLadderLength2() throws Exception {
		String beginWord = "red";
		String endWord = "tax";
		List<String> wordList = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
		
		assertEquals(3, obj.findLadders(beginWord, endWord, wordList).size());
	}

}
