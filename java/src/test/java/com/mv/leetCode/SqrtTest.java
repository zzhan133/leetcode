package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SqrtTest {

	private Sqrt obj = new Sqrt();
	
	@Test
	public void testMySqrt() throws Exception {
		int ans = obj.mySqrt(37823382);
		assertEquals(6150, ans);
	}
	
	@Test
	public void testMySqrt2() throws Exception {
		int ans = obj.mySqrt(2147395599);
		assertEquals(46339, ans);
	}

	@Test
	public void testMySqrt3() throws Exception {
		int ans = obj.mySqrt(Integer.MAX_VALUE);
		assertEquals(46340, ans);
	}

}
