package com.mv.leetCode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContinuousSubarraySumTest {
	
	private ContinuousSubarraySum obj = new ContinuousSubarraySum();

	@Test
	public void testCheckSubarraySum() throws Exception {
		int[] testArray = {23,1};
		int k = 0;
		boolean result = obj.checkSubarraySum(testArray, k);
		assertTrue(result);	
//		assertTrue(result);	
	}
	
	@Test
	public void testCheckSubarraySum1() throws Exception {
		int[] testArray = {23, 2, 4, 6, 7};
		int k = 6;
		boolean result = obj.checkSubarraySum(testArray, k);
		assertTrue(result);
	}
	
	@Test
	public void testCheckSubarraySum2() throws Exception {
		int[] testArray = {23, 2, 6, 4, 7};
		int k = 6;
		boolean result = obj.checkSubarraySum(testArray, k);
		assertTrue(result);
	}

}