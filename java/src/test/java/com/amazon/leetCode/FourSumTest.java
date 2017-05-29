package com.amazon.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FourSumTest {
	
	private FourSum obj = new FourSum();

	@Test
	public void testFourSum() throws Exception {
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> ans = obj.fourSum(nums, 0);
		assertEquals(3, ans.size());
	}
	
	@Test
	public void testFourSum2() throws Exception {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		List<List<Integer>> ans = obj.fourSum(nums, 0);
		assertEquals(8, ans.size());
	}

}
