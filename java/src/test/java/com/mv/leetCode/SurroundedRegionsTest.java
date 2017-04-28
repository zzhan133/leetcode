package com.mv.leetCode;

import org.junit.Test;

public class SurroundedRegionsTest {

	private SurroundedRegions obj = new SurroundedRegions();
	
	@Test
	public void testSolve() throws Exception {
		char[][] board = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
		};
		
		obj.solve(board);
		print(board);
	}

	@Test
	public void testSolve1() throws Exception {
		char[][] board = {
				{'O', 'O', 'O'},
				{'O', 'O', 'O'},
				{'O', 'O', 'O'}
		};
		
		obj.solve(board);
		print(board);
	}
	
	private void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
