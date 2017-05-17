package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowTest {

	@Test
	public void testPow() throws Exception {
		Pow obj = new Pow();
		assertEquals( 4.0, obj.myPow(-2, 2), 0.1);
		assertEquals( -2, obj.myPow(-2, 1), 0.1);
		assertEquals( 1.0, obj.myPow(-1, Integer.MIN_VALUE), 0.1);
		assertEquals( 0.0, obj.myPow(-2, Integer.MIN_VALUE), 0.1);
		System.out.println(obj.myPow(-2, 2));
		System.out.println(obj.myPow(-1, Integer.MIN_VALUE));
		System.out.println(obj.myPow(3, 3));
		System.out.println(obj.myPow(3, 4));
		System.out.println(obj.myPow(3, 5));
		System.out.println(obj.myPow(3, 6));
		System.out.println(obj.myPow(3, -7));
		System.out.println(Math.abs(-110));
	}
	
	@Test
	public void testPow1() throws Exception {
		Pow obj = new Pow();
//		assertEquals( 1.0, obj.myPow(-1, Integer.MIN_VALUE), 0.1);
		assertEquals( 0.0, obj.myPow(-2, Integer.MIN_VALUE), 0.1);

	}

}
