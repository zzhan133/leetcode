package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermutationSequenceTest {

	private PermutationSequence obj = new PermutationSequence();
	
	@Test
	public void testGetPermutation() throws Exception {
		assertEquals("213", obj.getPermutation(3, 3));
	}
	
	@Test
	public void testGetPermutation1() throws Exception {
		assertEquals("1", obj.getPermutation(1, 3));
	}
	
	@Test
	public void testGetPermutation2() throws Exception {
		assertEquals("123", obj.getPermutation(3, 1));
	}
	
	@Test
	public void testGetPermutation3() throws Exception {
		assertEquals("321", obj.getPermutation(3, 6));
	}
	
	@Test
	public void testGetPermutation4() throws Exception {
		assertEquals("312", obj.getPermutation(3, 5));
	}

}
