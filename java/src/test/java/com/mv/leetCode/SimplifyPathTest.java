package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimplifyPathTest {

	private SimplifyPath obj = new SimplifyPath();
	
	@Test
	public void testSimplifyPath() throws Exception {
		String path = "/home/";
		assertEquals("/home", obj.simplifyPath(path));
	}

	@Test
	public void testSimplifyPath1() throws Exception {
		String path = "/a/./b/../../c/";
		assertEquals("/c", obj.simplifyPath(path));
	}

	@Test
	public void testSimplifyPath2() throws Exception {
		String path = "/";
		assertEquals("/", obj.simplifyPath(path));
	}
	
	@Test
	public void testSimplifyPath3() throws Exception {
		String path = "///";
		assertEquals("/", obj.simplifyPath(path));
	}
	
	@Test
	public void testSimplifyPath4() throws Exception {
		String path = "/.";
		assertEquals("/", obj.simplifyPath(path));
	}
	
	@Test
	public void testSimplifyPath5() throws Exception {
		String path = "///";
		assertEquals("/", obj.simplifyPath(path));
	}
	
	@Test
	public void testSimplifyPath6() throws Exception {
		String path = "/...";
		assertEquals("/...", obj.simplifyPath(path));
	}
}
