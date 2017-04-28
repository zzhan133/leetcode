package com.mv.leetCode;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 1 || board[0].length <= 1)
			return;
		int M = board.length;
		int N = board[0].length;
		boolean[][] isRemain = new boolean[M][N];
		

		for (int i = 0; i <= N - 1; i++) {
			if (board[0][i] == 'O') {
				dfs(board, isRemain, 0, i);
			}
		}

		for (int i = 0; i < board[0].length; i++) {
			if (board[M - 1][i] == 'O') {
				dfs(board, isRemain, M - 1, i);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				dfs(board, isRemain, i, 0);
			}
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][N - 1] == 'O') {
				dfs(board, isRemain, i, N - 1);
			}
		}

		for (int i = 0; i < isRemain.length; i++) {
			for (int j = 0; j < isRemain[0].length; j++) {
				if (isRemain[i][j])
					continue;
				else {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, boolean[][] isRemain, int rPos, int cPos) {
		if (isRemain[rPos][cPos])
			return;
		isRemain[rPos][cPos] = true;
		if (cPos - 1 >= 0 && board[rPos][cPos - 1] == 'O')
			dfs(board, isRemain, rPos, cPos - 1);
		if (cPos + 1 < board[0].length && board[rPos][cPos + 1] == 'O')
			dfs(board, isRemain, rPos, cPos + 1);
		if (rPos - 1 >= 0 && board[rPos - 1][cPos] == 'O')
			dfs(board, isRemain, rPos - 1, cPos);
		if (rPos + 1 < board.length && board[rPos + 1][cPos] == 'O')
			dfs(board, isRemain, rPos + 1, cPos);
	}

	private char[][] transform(char[][] board) {
		int rBegin = getRowBegin(board);
		if (rBegin == board.length)
			return new char[1][1];
		int rEnd = getRowEnd(board, rBegin);
		if (rBegin + 1 == rEnd)
			return new char[1][1];
		int cBegin = 0, cEnd = board[0].length - 1;
		while (cBegin < cEnd) {
			char tmp = ' ';
			for (int i = rBegin; i <= rEnd; i++) {
				tmp = board[i][cBegin];
				if (tmp == 'X')
					break;
			}
			if (tmp == 'X')
				break;
			cBegin++;
		}
		while (cEnd > cBegin) {
			char tmp = ' ';
			for (int i = rBegin; i <= rEnd; i++) {
				tmp = board[i][cEnd];
				if (tmp == 'X')
					break;
			}
			if (tmp == 'X')
				break;
			cEnd--;
		}
		int M = rEnd - rBegin + 1;
		int N = cEnd - cBegin + 1;
		char[][] newBoard = new char[M][N];
		for (int i = rBegin; i <= rEnd; i++) {
			for (int j = cBegin; j <= cEnd; j++) {
				newBoard[i - rBegin][j - cBegin] = board[i][j];
			}
		}
		return newBoard;
	}

	private int getRowEnd(char[][] board, int rBegin) {
		int pos = board.length - 1;
		while (pos > rBegin) {
			for (int i = 0; i < board[0].length; i++) {
				if (board[pos][i] == 'X')
					return pos;
			}
		}
		return pos;
	}

	private int getRowBegin(char[][] board) {
		int pos = 0;
		while (pos < board.length) {
			for (int i = 0; i < board[0].length; i++) {
				if (board[pos][i] == 'X')
					return pos;
			}
			pos++;
		}
		return pos;
	}

}
