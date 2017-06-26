package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberTest {

	private SingleNumber obj = new SingleNumber();

	@Test
	public void testSingleNumber1() throws Exception {
		int[] nums = { 1, 2, 2 };
		assertEquals(1, obj.singleNumber(nums));
	}

	@Test
	public void testSingleNumber2() throws Exception {
		int[] nums = { 2, 1, 2 };
		assertEquals(1, obj.singleNumber(nums));
	}

	@Test
	public void testSingleNumber3() throws Exception {
		int[] nums = { 2, 2, 1 };
		assertEquals(1, obj.singleNumber(nums));
	}

	@Test
	public void testSingleNumber4() throws Exception {
		int[] nums = { 3, 2, 2 };
		assertEquals(3, obj.singleNumber(nums));
	}

	@Test
	public void testSingleNumber5() throws Exception {
		int[] nums = { 2, 3, 2 };
		assertEquals(3, obj.singleNumber(nums));
	}

	@Test
	public void testSingleNumber6() throws Exception {
		int[] nums = { 2, 2, 3 };
		assertEquals(3, obj.singleNumber(nums));
	}
}
