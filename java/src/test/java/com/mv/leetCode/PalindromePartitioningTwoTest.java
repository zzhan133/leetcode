package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromePartitioningTwoTest {

	private PalindromePartitioningTwo obj = new PalindromePartitioningTwo();
	
	@Test
	public void testMinCut() throws Exception {
		assertEquals(1, obj.minCut("aab"));
	}

	@Test
	public void testMinCut1() throws Exception {
		assertEquals(0, obj.minCut("aabbaa"));
	}
}
