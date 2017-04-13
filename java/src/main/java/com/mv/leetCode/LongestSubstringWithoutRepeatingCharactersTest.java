package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

	@Test
	public void testLengthOfLongestSubstring() throws Exception {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		assertEquals(3, obj.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, obj.lengthOfLongestSubstring("c"));
		assertEquals(5, obj.lengthOfLongestSubstring("abcdabcde"));
		assertEquals(1, obj.lengthOfLongestSubstring("cc"));
		assertEquals(3, obj.lengthOfLongestSubstring("dvdf"));
		assertEquals(3, obj.lengthOfLongestSubstring("pwwkew"));
	}

}
