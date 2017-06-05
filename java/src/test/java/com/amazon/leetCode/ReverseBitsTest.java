package com.amazon.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseBitsTest {
	
	private ReverseBits obj = new ReverseBits();

	@Test
	public void testReverseBits() throws Exception {
		int ans = obj.reverseBits(43261596);
		assertEquals(964176192, ans);
	}
	
	@Test
	public void testReverseBits1() throws Exception {
		int ans = obj.reverseBits(1);
		assertEquals(Integer.MIN_VALUE, ans);
	}
	

}