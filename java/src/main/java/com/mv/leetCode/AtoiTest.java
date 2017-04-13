package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtoiTest {
	
	Atoi obj = new Atoi();

	@Test
	public void testMyAtoi() throws Exception {
		assertEquals(10, obj.myAtoi("10"));
		assertEquals(-10, obj.myAtoi("-10"));
		assertEquals(-10, obj.myAtoi("  -10"));
		assertEquals(-10, obj.myAtoi("	-10"));
		assertEquals(-10, obj.myAtoi("  		-10"));
		assertEquals(10, obj.myAtoi("  		10"));
		assertEquals(2310, obj.myAtoi("  		002310  "));
		assertEquals(Integer.MIN_VALUE, obj.myAtoi("-2147483648"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMyAtoiException() throws Exception {
		assertEquals(10, obj.myAtoi("10e"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMyAtoiException1() throws Exception {
		assertEquals(10, obj.myAtoi("e+10"));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMyAtoiException2() throws Exception {
		assertEquals(10, obj.myAtoi("10e"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMyAtoiException3() throws Exception {
		assertEquals(10, obj.myAtoi("-2147483649"));
	}
}
