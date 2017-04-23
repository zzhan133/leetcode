package com.mv.leetCode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int M = board.length;
		int N = board[0].length;
		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if(visit(board, word.substring(1), visited, i, j)){
						return true;
					} else {
						visited[i][j] = false;
					}
				}
			}
			
		}
		return false;
	}
	
	//started on i, j to search next matching char [i-1][j], [i+1][j], [i][j-1], [i][j+1] 
	private boolean visit(char[][] board, String word, boolean[][] visited, int i, int j) {
		if(word == null || word.isEmpty()){
			return true;
		}
		char next = word.charAt(0);
		if(i > 0 && !visited[i-1][j] && board[i-1][j]  == next) {
			visited[i-1][j] = true;
			if( visit(board, word.substring(1), visited, i-1, j)){
				return true;
			} else {
				visited[i-1][j] = false;
			}
		}
		
		if(i < board.length - 1 && !visited[i+1][j] && board[i+1][j] == next) {
			visited[i+1][j] = true;
			if(visit(board, word.substring(1), visited, i+1, j)){
				return true;
			} else{
				visited[i+1][j] = false;
			}
		}
		
		if(j > 0 && !visited[i][j-1] && board[i][j-1]  == next) {
			visited[i][j-1] = true;
			if( visit(board, word.substring(1), visited, i, j-1)){
				return true;
			} else {
				visited[i][j-1] = false;
			}
		}
		
		if(j < board[0].length - 1 && !visited[i][j+1] && board[i][j+1]  == next) {
			visited[i][j+1] = true;
			if( visit(board, word.substring(1), visited, i, j+1)){
				return true;
			} else {
				visited[i][j+1] = false;
			}
		}
		return false;
	}

}
