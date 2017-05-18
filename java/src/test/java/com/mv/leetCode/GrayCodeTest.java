package com.mv.leetCode;

import java.util.List;

import org.junit.Test;

public class GrayCodeTest {

	@Test
	public void testGrayCode() throws Exception {
		GrayCode obj = new GrayCode();
		List<Integer> ans = obj.grayCode(3);
		System.out.println(ans);
	}

}
