package com.mv.leetCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordSearchTest {

	private WordSearch obj = new WordSearch();
	@Test
	public void testExist() throws Exception {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}	
		};
		
		assertTrue(obj.exist(board, "ABCCED"));
		
		assertTrue(obj.exist(board, "SEE"));
		assertTrue(!obj.exist(board, "ABCB"));
	}

}
