package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LetterCombinationsOf_a_PhoneNumberTest {
	
	private LetterCombinationsOf_a_PhoneNumber obj = new LetterCombinationsOf_a_PhoneNumber();

	@Test
	public void testLetterCombinations() throws Exception {
		assertEquals(9, obj.letterCombinations("23").size());
		assertEquals(0, obj.letterCombinations("0").size());
		
	}
	
	

}
