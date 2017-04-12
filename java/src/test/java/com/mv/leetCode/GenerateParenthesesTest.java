package com.mv.leetCode;

import java.util.List;

import org.junit.Test;

public class GenerateParenthesesTest {

	@Test
	public void testFunc() throws Exception {
		GenerateParentheses obj = new GenerateParentheses();
		List<String> results = obj.generateParenthesis(4);
		System.out.println(results);
	}

}
