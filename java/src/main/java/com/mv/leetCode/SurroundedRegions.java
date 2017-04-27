package com.mv.leetCode;

public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == 'O') {
					proc(board, i, j);
				}
			}
		}
    }
    
    private boolean proc(char[][] board, int i, int j) {
		int M = board.length;
		int N = board[0].length;
		if(i == 0 && board[i][j] == 'O') return false;
		if(i == 0 && board[i][j] == 'X') return true;
		if(j == 0 && board[i][j] == 'O') return false;
		if(j == 0 && board[i][j] == 'X') return true;
		if(i == M - 1 && board[i][j] == 'O') return false;
		if(i == M - 1 && board[i][j] == 'X') return true;
		if(j == N - 1 && board[i][j] == 'O') return false;
		if(j == N - 1 && board[i][j] == 'X') return true;
		if(board[i][j] == 'X') return false;
		board[i][j] = 'X';
		if(board[i][j+1] == 'O' && board[i][j-1] == 'O' && board[i-1][j] == 'O' && board[i+1][j] == 'O'){
			return true;
		}
		if(proc(board, i, j+1)) return true;
		if(proc(board, i, j-1 )) return true;
		if(proc(board, i - 1, j )) return true;
		if(proc(board, i + 1, j )) return true;
		board[i][i] = 'O';
		return false;
	}


}
