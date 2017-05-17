package com.mv.leetCode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

	private CombinationSum obj = new CombinationSum();

	@Test
	public void testDfs() throws Exception {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> ans = obj.combinationSum(candidates, target);
		assertEquals(2, ans.size());
	}

}
