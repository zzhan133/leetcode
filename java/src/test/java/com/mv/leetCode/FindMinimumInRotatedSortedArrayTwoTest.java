package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTwoTest {

	private FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
	
	@Test
	public void testMaxProduct4() throws Exception {
		int[] nums = {1, 1};
		assertEquals(1, obj.findMin(nums));
	}

}
