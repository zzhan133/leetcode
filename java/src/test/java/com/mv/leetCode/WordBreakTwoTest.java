package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordBreakTwoTest {
	
	private WordBreakTwo obj = new WordBreakTwo();

	@Test
	public void testWordBreak() throws Exception {
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		String s = "leetcode";
		List<String> com = obj.wordBreak(s, wordDict); 
		System.out.println(com);
		assertEquals(1, com.size());
	}
	
	@Test
	public void testWordBreak1() throws Exception {
		List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		String s = "catsanddog";
		List<String> com = obj.wordBreak(s, wordDict); 
		System.out.println(com);
		assertEquals(2, com.size());
	}

	@Test
	public void testWordBreak2() throws Exception {
		List<String> wordDict = new ArrayList<>(Arrays.asList("a","b","bbb","bbbb"));
		String s = "bb";
		List<String> com = obj.wordBreak(s, wordDict); 
		System.out.println(com);
		assertEquals(1, com.size());
	}
	
	@Test
	public void testWordBreak3() throws Exception {
		List<String> wordDict = new ArrayList<>(Arrays.asList("pear","apple","peach"));
		String s = "apple";
		List<String> com = obj.wordBreak(s, wordDict); 
		System.out.println(com);
		assertEquals(1, com.size());
	}

}
