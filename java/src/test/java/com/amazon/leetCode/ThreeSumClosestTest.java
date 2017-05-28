package com.amazon.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThreeSumClosestTest {

	@Test
	public void testThreeSumClosest() throws Exception {
		ThreeSumClosest obj = new ThreeSumClosest();
		int[] nums = {-1, 1, -4, 2};
		int ans = obj.threeSumClosest(nums, 1);
		assertEquals(2, ans);
	}

	@Test
	public void testThreeSumClosest2() throws Exception {
		ThreeSumClosest obj = new ThreeSumClosest();
		int[] nums = {1,1,-1,-1,3};
		int ans = obj.threeSumClosest(nums, 3);
		assertEquals(3, ans);
	}
}
