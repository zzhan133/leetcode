package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class NQueensTest {

	private NQueens obj = new NQueens();
	@Test
	public void testSolveNQueens() throws Exception {
		List<List<String>> ans = obj.solveNQueens(4);
		assertEquals(2, ans.size());
		printAns(ans);
	}
	private void printAns(List<List<String>> ans) {
		for (List<String> list : ans) {
			System.out.println(list);
		}
		
	}

}
