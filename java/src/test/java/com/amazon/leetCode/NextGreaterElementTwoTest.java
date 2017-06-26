package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextGreaterElementTwoTest {

	private NextGreaterElementTwo obj = new NextGreaterElementTwo();
	
	@Test
	public void testNextGreaterElements() throws Exception {
		int[] nums = { 1, 2, 1};
		int[] ans = {2, -1, 2};
		int[] real = obj.nextGreaterElements(nums);
		assertArrayEquals(ans, real);
	}
	
	@Test
	public void testNextGreaterElements2() throws Exception {
		int[] nums = {1,2,3,4,3};
		int[] ans = {2, 3, 4, -1, 4};
		int[] real = obj.nextGreaterElements(nums);
		assertArrayEquals(ans, real);
	}

	@Test
	public void testNextGreaterElements3() throws Exception {
		int[] nums = {1,2,3,4,2};
		int[] ans = {2, 3, 4, -1, 3};
		int[] real = obj.nextGreaterElements(nums);
		assertArrayEquals(ans, real);
	}
	
	@Test
	public void testNextGreaterElements4() throws Exception {
		int[] nums = {5,4,3,2,1};
		int[] ans = {-1, 5, 5, 5, 5};
		int[] real = obj.nextGreaterElements(nums);
		assertArrayEquals(ans, real);
	}

}
