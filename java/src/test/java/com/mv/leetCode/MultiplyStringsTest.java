package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplyStringsTest {
	
	private MultiplyStrings obj = new MultiplyStrings();
	
	@Test
	public void testMultiply() throws Exception {
		assertEquals("0", obj.multiply("0", "9"));
	}
	
	@Test
	public void testMultiply1() throws Exception {
		assertEquals("121932631112635269", obj.multiply("123456789", "987654321"));
	}

//	@Test
//	public void testMultiply2() throws Exception {
//		assertEquals("2", obj.multiply2("1"));
//		assertEquals("20", obj.multiply2("10"));
//		assertEquals("36", obj.multiply2("18"));
//		assertEquals("110", obj.multiply2("55"));
//	}
//	
//	@Test
//	public void testDivide2() throws Exception {
//		assertEquals("2", obj.divide2("4"));
//		assertEquals("5", obj.divide2("10"));
//		assertEquals("18", obj.divide2("36"));
//		assertEquals("555", obj.divide2("1110"));
//	}
//	
//	@Test
//	public void testAdd() throws Exception {
//		assertEquals("10", obj.add("4", "6"));
//		assertEquals("1000033", obj.add("34", "999999"));
//	}


}
