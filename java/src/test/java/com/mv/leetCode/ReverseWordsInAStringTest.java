package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseWordsInAStringTest {

	@Test
	public void testReverseWords() throws Exception {
		ReverseWordsInAString obj = new ReverseWordsInAString();
		String ans = obj.reverseWords("the sky is blue");
		assertEquals("blue is sky the", ans);
	}

	@Test
	public void testReverseWords2() throws Exception {
		ReverseWordsInAString obj = new ReverseWordsInAString();
		String ans = obj.reverseWords(" ");
		assertEquals("", ans);
	}
	
	@Test
	public void testReverseWords3() throws Exception {
		ReverseWordsInAString obj = new ReverseWordsInAString();
		String ans = obj.reverseWords(" 1");
		assertEquals("1", ans);
	}
	
	@Test
	public void testReverseWords4() throws Exception {
		ReverseWordsInAString obj = new ReverseWordsInAString();
		String ans = obj.reverseWords("1 ");
		assertEquals("1", ans);
	}
}
