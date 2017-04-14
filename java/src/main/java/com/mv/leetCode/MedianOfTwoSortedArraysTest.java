package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

	private MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
	
	@Test
	public void testFindMedianSortedArrays() throws Exception {
		int[] nums1 = {1, 2};
		int[] nums2 = {3,4};
		assertEquals(2.5, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays2() throws Exception {
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {3,4};
		assertEquals(3.0, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays3() throws Exception {
		int[] nums1 = {};
		int[] nums2 = {3,4};
		assertEquals(3.5, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays4() throws Exception {
		int[] nums1 = {1, 2};
		int[] nums2 = {1, 2};
		assertEquals(1.5, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays5() throws Exception {
		int[] nums1 = {1};
		int[] nums2 = {2, 3};
		assertEquals(2, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays6() throws Exception {
		int[] nums1 = {4};
		int[] nums2 = {2, 3};
		assertEquals(3, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays7() throws Exception {
		int[] nums1 = {2};
		int[] nums2 = {1, 3, 4};
		assertEquals(2.5, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	
	@Test
	public void testFindMedianSortedArrays8() throws Exception {
		int[] nums1 = {1, 4};
		int[] nums2 = {2, 3};
		assertEquals(2.5, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
	@Test
	public void testFindMedianSortedArrays9() throws Exception {
		int[] nums1 = {3, 4};
		int[] nums2 = {1, 2, 5};
		assertEquals(3.0, obj.findMedianSortedArrays(nums1, nums2), 0.1);
	}
}
