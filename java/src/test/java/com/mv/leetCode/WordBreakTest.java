/**
 * 
 */
package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Zhe
 *
 */
public class WordBreakTest {
	
	private WordBreak obj = new WordBreak();
	
	@Test
	public void testLadderLength() throws Exception {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		
		assertEquals(true, obj.wordBreak(s, wordDict));
	}
	
	@Test
	public void testWordBreak() throws Exception {
		String s = "bb";
		List<String> wordDict = new ArrayList<>(Arrays.asList("a","b","bbb","bbbb"));
		
		assertEquals(true, obj.wordBreak(s, wordDict));
	}

}
