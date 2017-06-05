package com.mv.leetCode;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LargestNumberTest {

	@Test
	public void testLargestNumber0() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {3, 30, 34, 5, 9};
		assertEquals("9534330", obj.largestNumber(nums));
	}
	
	@Test
	public void testLargestNumber1() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {};
		assertEquals("", obj.largestNumber(nums));
	}
	
	@Test
	public void testLargestNumber2() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {0, 0};
		assertEquals("0", obj.largestNumber(nums));
	}
	
	@Test
	public void testLargestNumber3() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {0, 0, 1};
		assertEquals("100", obj.largestNumber(nums));
	}
	

	@Test
	public void testLargestNumber4() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
		assertEquals("9609938824824769735703560743981399", obj.largestNumber(nums));
	}
	
	@Test
	public void testLargestNumber5() throws Exception {
		LargestNumber obj = new LargestNumber();
		int[] nums = {121, 12};
		assertEquals("12121", obj.largestNumber(nums));
	}
	

}
