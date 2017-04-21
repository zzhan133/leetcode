package com.mv.leetCode;

import org.junit.Test;

public class RotateArrayTest {

	private RotateArray obj = new RotateArray();
	
	@Test
	public void testRotate() throws Exception {
		int[] nums = {-1,-100,3,99};
		obj.rotate(nums, 3);
	}

}
