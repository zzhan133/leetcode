package com.mv.leetCode;

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
	public void testFourSum1() throws Exception {
		int[] nums = {0, 0, 0, 0};
		List<List<Integer>> ans = obj.fourSum(nums, 0);
		assertEquals(1, ans.size());
	}

	@Test
	public void testFourSum2() throws Exception {
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		List<List<Integer>> ans = obj.fourSum(nums, -11);
		assertEquals(1, ans.size());
	}
	
	@Test
	public void testFourSum3() throws Exception {
		int[] nums = {-4,-3,-2,-1,0,0,1,2,3,4};
		List<List<Integer>> ans = obj.fourSum(nums, 0);
		assertEquals(16, ans.size());
	}
}
