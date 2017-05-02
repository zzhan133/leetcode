package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOfOneBitsTest {

	private NumberOfOneBits obj = new NumberOfOneBits();
	
	@Test
	public void testHammingWeight() throws Exception {
		assertEquals(1, obj.hammingWeight(Integer.MIN_VALUE));
	}
	
	@Test
	public void testHammingWeight1() throws Exception {
		assertEquals(31, obj.hammingWeight(Integer.MAX_VALUE));
	}
	
	
	@Test
	public void testHammingWeight2() throws Exception {
		assertEquals(32, obj.hammingWeight(0xffffffff));
	}


}
