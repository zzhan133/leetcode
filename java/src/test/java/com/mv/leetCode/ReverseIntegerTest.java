package com.mv.leetCode;

import org.junit.Test;

public class ReverseIntegerTest {

	@Test
	public void testReverse() throws Exception {
		ReverseInteger obj = new ReverseInteger();
		int input = Integer.MIN_VALUE;
		int ans = obj.reverse(input);
		System.out.println(ans);
	}

}
