package com.mv.leetCode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutationTest {

	private NextPermutation obj = new NextPermutation();
	
	@Test
	public void testNextPermutation() throws Exception {
		int[] nums = {1,2,3};
		obj.nextPermutation(nums);
		assertArrayEquals(new int[]{1, 3, 2},  nums);
	}

	@Test
	public void testNextPermutation1() throws Exception {
		int[] nums = {3,2,1};
		obj.nextPermutation(nums);
		assertArrayEquals(new int[]{1, 2, 3},  nums);
	}
	@Test
	public void testNextPermutation2() throws Exception {
		int[] nums = {2,3,1};
		obj.nextPermutation(nums);
		assertArrayEquals(new int[]{3, 1, 2},  nums);
	}
}
