package com.amazon.leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatchingTest {

	private WildcardMatching obj = new WildcardMatching();

	@Test
	public void testThreeSumClosest0() throws Exception {
		String s = "a";
		String p = "aa";
		assertFalse(obj.isMatch(s, p));
	}
	
	@Test
	public void testThreeSumClosest01() throws Exception {
		String s = "c";
		String p = "*?*";
		assertTrue(obj.isMatch(s, p));
	}
	
	@Test
	public void testThreeSumClosest02() throws Exception {
		String s = "ba";
		String p = "*a*";
		assertTrue(obj.isMatch(s, p));
	}


	@Test
	public void testThreeSumClosest1() throws Exception {
		String s = "aa";
		String p = "a";
		assertFalse(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest2() throws Exception {
		String s = "aa";
		String p = "*a*b";
		assertFalse(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest3() throws Exception {
		String s = "aab";
		String p = "?aab";
		assertFalse(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest4() throws Exception {
		String s = "aab";
		String p = "aab";
		assertTrue(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest5() throws Exception {
		String s = "aab";
		String p = "a*ab";
		assertTrue(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest6() throws Exception {
		String s = "aa";
		String p = "a";
		assertFalse(obj.isMatch(s, p));
	}

	@Test
	public void testThreeSumClosest7() throws Exception {
		String s = "aa";
		String p = "a*";
		assertTrue(obj.isMatch(s, p));
	}

}
