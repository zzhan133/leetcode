package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrappingRainWaterTest {

	private TrappingRainWater obj = new TrappingRainWater();
	
	@Test
	public void testTrap() throws Exception {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int ans = obj.trap(height);
		assertEquals(6, ans);
	}
	
	@Test
	public void testTrap1() throws Exception {
		int[] height = {2, 0, 2};
		int ans = obj.trap(height);
		assertEquals(2, ans);
	}

	@Test
	public void testTrap2() throws Exception {
		int[] height = {};
		int ans = obj.trap(height);
		assertEquals(0, ans);
	}

}
