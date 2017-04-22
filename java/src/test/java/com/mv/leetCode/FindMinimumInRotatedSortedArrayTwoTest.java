package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTwoTest {

	private FindMinimumInRotatedSortedArrayTwo obj = new FindMinimumInRotatedSortedArrayTwo();
	
	@Test
	public void testMaxProduct1() throws Exception {
		int[] nums = {1, 1};
		assertEquals(1, obj.findMin(nums));
	}

	@Test
	public void testMaxProduct2() throws Exception {
		int[] nums = {0, 1, 2, 4, 5, 6, 7};
		assertEquals(0, obj.findMin(nums));
	}
	
	@Test
	public void testMaxProduct3() throws Exception {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		assertEquals(0, obj.findMin(nums));
	}
}
