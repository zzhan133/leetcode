package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {
	
	private FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
	
	@Test
	public void testMaxProduct4() throws Exception {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		assertEquals(0, obj.findMin(nums));
	}

}
