package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	private SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
	
	@Test
	public void testSearch() throws Exception {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int ans = obj.search(nums, 5);
		assertEquals(1, ans);
	}
	
	@Test
	public void testSearch2() throws Exception {
		int[] nums = {1, 3};
		int ans = obj.search(nums, 3);
		assertEquals(1, ans);
	}
	
	@Test
	public void testSearch3() throws Exception {
		int[] nums = {4,5,6,7,8,1,2,3};
		int ans = obj.search(nums, 8);
		assertEquals(4, ans);
	}

}
