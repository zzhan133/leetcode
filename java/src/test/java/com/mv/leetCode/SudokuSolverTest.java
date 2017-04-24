package com.mv.leetCode;

import org.junit.Test;

public class SudokuSolverTest {

	private SudokuSolver obj = new SudokuSolver();
	
	@Test
	public void testSolveSudoku() throws Exception {
		String[] strs = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][] sudoku = new char[9][9];
		for (int i = 0; i < strs.length; i++) {
			sudoku[i] = strs[i].toCharArray();
		}
		obj.solveSudoku(sudoku);
		System.out.println("Done");
	}

}
