package com.mv.leetCode;

import org.junit.Test;

public class SearchForRangeTest {
	
	private SearchForRange obj = new SearchForRange();

	@Test
	public void testSearchRange() throws Exception {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] ans = obj.searchRange(nums, 8);
	}

}
