package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PermutationsTwoTest {

	private PermutationsTwo obj = new PermutationsTwo();
	
	@Test
	public void testGetPermutation() throws Exception {
		int[] nums = {0,1,0,0,9};
		List<List<Integer>> ans = obj.permuteUnique(nums);
		assertEquals(20, ans.size());
	}
	
	@Test
	public void testGetPermutation1() throws Exception {
		int[] nums = {2, 2, 1, 1};
		List<List<Integer>> ans = obj.permuteUnique(nums);
		assertEquals(6, ans.size());
	}
	
	@Test
	public void testGetPermutation3() throws Exception {
		int[] nums = { 2, 2, 1};
		List<List<Integer>> ans = obj.permuteUnique(nums);
		assertEquals(3, ans.size());
	}

}
