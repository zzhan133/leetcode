package com.mv.leetCode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] isVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(grid[i][j] == '1') isVisited[i][j] = false;
				else isVisited[i][j] = true;
			}
		}
        int ans = 0;
        for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisited[i][j]){
					ans++;
					dfs(isVisited, i, j);
				}
			}
		}
        
        
        return ans;
    }

	private void dfs(boolean[][] isVisited, int i, int j) {
		if(i < 0 || i >= isVisited.length || j < 0 || j>=isVisited[0].length) return;
		if(isVisited[i][j] == false) {
			isVisited[i][j] = true;
			dfs(isVisited, i, j-1);
			dfs(isVisited, i-1, j);
			dfs(isVisited, i, j+1);
			dfs(isVisited, i+1, j);
		}
		
	}
}
