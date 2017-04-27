package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PalindromePartitioningTest {

	private PalindromePartitioning obj = new PalindromePartitioning();
	
	@Test
	public void testPartition() throws Exception {
		
		List<String> strs = new ArrayList<>();
		strs.add("hello");
		strs.add("world");
		System.out.println(strs);
		
		List<List<String>> ans = obj.partition("aab");
		assertEquals(2, ans.size());
		
		
	}

}
