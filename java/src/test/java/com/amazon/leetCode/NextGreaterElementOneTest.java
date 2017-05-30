package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextGreaterElementOneTest {

	@Test
	public void testNextGreaterElement() throws Exception {
		int[] nums1 = {2, 4};
		int[] nums2 = {1, 2, 3, 4};
		NextGreaterElementOne obj = new NextGreaterElementOne();
		int[] ans = obj.nextGreaterElement(nums1, nums2);
		assertEquals(2, ans.length);
	}
	
	@Test
	public void testNextGreaterElement1() throws Exception {
		int[] nums1 = {1,3,5,2,4,6,7};
		int[] nums2 = {6,5,4,3,2,1,7};
		NextGreaterElementOne obj = new NextGreaterElementOne();
		int[] ans = obj.nextGreaterElement(nums1, nums2);
	}
	
	@Test
	public void testNextGreaterElement2() throws Exception {
		int[] nums1 = {137,59,92,122,52,131,79,236};
		int[] nums2 = {137,59,92,122,52,131,79,236};
		NextGreaterElementOne obj = new NextGreaterElementOne();
		int[] ans = obj.nextGreaterElement(nums1, nums2);
		assertEquals(8, ans.length);
	}



}
