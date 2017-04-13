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
		assertEquals(Integer.MAX_VALUE, obj.myAtoi("2147483648"));
		assertEquals(Integer.MIN_VALUE, obj.myAtoi("      -11919730356x"));
		
		assertEquals(0, obj.myAtoi("+-2"));
		assertEquals(1, obj.myAtoi("1"));
		assertEquals(0, obj.myAtoi("+"));
	}
	
	public void testMyAtoiException() throws Exception {
		assertEquals(0, obj.myAtoi("10e"));
	}
	
	public void testMyAtoiException1() throws Exception {
		assertEquals(0, obj.myAtoi("e+10"));
	}

	public void testMyAtoiException2() throws Exception {
		assertEquals(0, obj.myAtoi("10e"));
	}
	
	public void testMyAtoiException3() throws Exception {
		assertEquals(0, obj.myAtoi("-2147483649"));
	}
}
