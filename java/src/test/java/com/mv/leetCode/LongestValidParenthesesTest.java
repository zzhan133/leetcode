package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestValidParenthesesTest {
	
	private LongestValidParentheses obj = new LongestValidParentheses();

	@Test
	public void testLongestValidParentheses() throws Exception {
		assertEquals(2, obj.longestValidParentheses("()(()"));
	}
	
	@Test
	public void testLongestValidParentheses1() throws Exception {
		assertEquals(2, obj.longestValidParentheses("(()"));
	}
	
	@Test
	public void testLongestValidParentheses2() throws Exception {
		assertEquals(4, obj.longestValidParentheses(")()())"));
	}
	
	@Test
	public void testLongestValidParentheses3() throws Exception {
		assertEquals(2, obj.longestValidParentheses("(()(((()"));
	}
	
	@Test
	public void testLongestValidParentheses4() throws Exception {
		assertEquals(4, obj.longestValidParentheses("(()()"));
	}
	
	@Test
	public void testLongestValidParentheses5() throws Exception {
		assertEquals(4, obj.longestValidParentheses(")()())()()("));
	}

}
