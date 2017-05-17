package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstMissingPositiveTest {

	private FirstMissingPositive obj = new FirstMissingPositive();
	
	@Test
	public void testFirstMissingPositive() throws Exception {
		int[] nums = {1,2,0};
		assertEquals(3,obj.firstMissingPositive(nums));
	}

	@Test
	public void testFirstMissingPositive1() throws Exception {
		int[] nums = {3,4,-1,1};
		assertEquals(2,obj.firstMissingPositive(nums));
	}
	
	@Test
	public void testFirstMissingPositive2() throws Exception {
		int[] nums = {0};
		assertEquals(1,obj.firstMissingPositive(nums));
	}
	@Test
	public void testFirstMissingPositive3() throws Exception {
		int[] nums = {1};
		assertEquals(2,obj.firstMissingPositive(nums));
	}
	@Test
	public void testFirstMissingPositive4() throws Exception {
		int[] nums = {-2, -1};
		assertEquals(1 ,obj.firstMissingPositive(nums));
	}
	
	@Test
	public void testFirstMissingPositive5() throws Exception {
		int[] nums = {1, 0};
		assertEquals(2 ,obj.firstMissingPositive(nums));
	}
	
	@Test
	public void testFirstMissingPositive6() throws Exception {
		int[] nums = {1, 1};
		assertEquals(2 ,obj.firstMissingPositive(nums));
	}
	
	@Test
	public void testFirstMissingPositive7() throws Exception {
		int[] nums = {2, 1};
		assertEquals(3 ,obj.firstMissingPositive(nums));
	}
	
	@Test
	public void testFirstMissingPositive8() throws Exception {
		int[] nums = {3, 2};
		assertEquals(1 ,obj.firstMissingPositive(nums));
	}
}
