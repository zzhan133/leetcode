package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestPalindromicSubstringTest {

	private LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
	
	@Test
	public void testCenter() throws Exception {
		assertEquals("bab", obj.longestPalindrome("babad"));
	}

}
