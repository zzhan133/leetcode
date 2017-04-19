package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumGapTest {

	private MaximumGap obj = new MaximumGap();
	
	@Test
	public void testMaximumGap() throws Exception {
		int[] nums = {11, 2, 4, 5, 7, 8};
		assertEquals(3, obj.maximumGap(nums));
	}

}
