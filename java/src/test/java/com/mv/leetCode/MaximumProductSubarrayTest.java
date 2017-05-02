package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumProductSubarrayTest {
	
	private MaximumProductSubarray obj = new MaximumProductSubarray();

	@Test
	public void testMaxProduct() throws Exception {
		int[] nums = {2,3,-2,4};
		assertEquals(6, obj.maxProduct(nums));
	}

	@Test
	public void testMaxProduct1() throws Exception {
		int[] nums = {2,0,3,-2,4};
		assertEquals(4, obj.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct2() throws Exception {
		int[] nums = {0,0,0,2,3,-2,4};
		assertEquals(6, obj.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct3() throws Exception {
		int[] nums = {0,2};
		assertEquals(2, obj.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct4() throws Exception {
		int[] nums = {-2, 0};
		assertEquals(0, obj.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct5() throws Exception {
		int[] nums = {-4,-3,-2};
		assertEquals(12, obj.maxProduct(nums));
	}
	
	@Test
	public void testMaxProduct6() throws Exception {
		int[] nums = {-1,-2,-3,0};
		assertEquals(6, obj.maxProduct(nums));
	}
	
	
	@Test
	public void testMaxProduct7() throws Exception {
		int[] nums = {-5, 0, 2};
		assertEquals(2, obj.maxProduct(nums));
	}
	
}
