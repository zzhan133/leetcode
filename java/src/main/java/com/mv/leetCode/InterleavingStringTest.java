package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InterleavingStringTest {

	private InterleavingString obj = new InterleavingString();
	
	@Test
	public void testIsInterleaveStartsWith1() throws Exception {
		assertEquals(false, obj.isInterleave ("aabd", "abdc", "aabdbadc"));
	}
	
	@Test
	public void testIsInterleaveStartsWith11() throws Exception {
		assertEquals(true, obj.isInterleave ("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	@Test
	public void testIsInterleaveStartsWith() throws Exception {
		assertEquals(true, obj.isInterleave ("", "", ""));
		assertEquals(true, obj.isInterleave ("", "a", "a"));
		assertEquals(false, obj.isInterleave ("a", "b", "ac"));
		assertEquals(false, obj.isInterleave ("ab", "a", "ba"));
		
		assertEquals(false, obj.isInterleave ("aabcc", "dbbca", "aadbbbaccc"));
	}

}
