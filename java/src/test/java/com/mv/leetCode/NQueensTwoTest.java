package com.mv.leetCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NQueensTwoTest {

	private NQueensTwo obj = new NQueensTwo();
	
	@Test
	public void testSolveNQueens() throws Exception {
		int total = obj.totalNQueens(4);
		assertEquals(2, total);
	}
	
	@Test
	public void testSolveNQueens1() throws Exception {
		int total = obj.totalNQueens(9);
		assertEquals(352, total);
	}
}
