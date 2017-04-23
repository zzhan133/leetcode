package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordLadderTest {
	
	private WordLadder obj  = new WordLadder();

	@Test
	public void testLadderLength() throws Exception {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		
		assertEquals(5, obj.ladderLength(beginWord, endWord, wordList));
	}

	@Test
	public void testLadderLength1() throws Exception {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
		
		assertEquals(0, obj.ladderLength(beginWord, endWord, wordList));
	}
}
