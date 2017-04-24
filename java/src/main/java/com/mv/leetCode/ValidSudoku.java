package com.mv.leetCode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	//1. validate row
    	for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			int[] freq = new int[row.length];
			for (int j = 0; j < row.length; j++) {
				char c = board[i][j];
				freq[c-'0']++;
			}
			for(int itemFreq: freq) {
				if(itemFreq > 1) return false;
			}
		}
    	
    	//2. validate column
    	for (int i = 0; i < board[0].length; i++) {
			int[] freq = new int[board[0].length];
			for (int j = 0; j < board.length; j++) {
				char c = board[j][i];
				freq[c-'0']++;
			}
			for(int itemFreq: freq) {
				if(itemFreq > 1) return false;
			}
		}
    	//3. validate subBoard
    	for (int i = 0; i < 9; i+=3) {
			for (int j = 0; j < 9; j+=3) {
				int[] freq = new int[board[0].length];
				for (int k = i; k < i+3; k++) {
					for (int l = j; l < j+3; l++) {
						char c = board[k][l];
						freq[c-'0']++;
					}
					for(int itemFreq: freq) {
						if(itemFreq > 1) return false;
					}
				}
			}
		}
        return true;
    }

}
