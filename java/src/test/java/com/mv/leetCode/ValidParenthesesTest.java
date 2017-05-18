package com.mv.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {

	@Test
	public void testIsValid() throws Exception {
		ValidParentheses obj = new ValidParentheses();
		assertTrue(obj.isValid("()"));
	}

}
