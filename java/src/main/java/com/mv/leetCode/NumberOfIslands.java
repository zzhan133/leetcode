package com.mv.leetCode;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

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
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    ans++;
                    queue.offer(new Coordinate(i, j));
                    while(!queue.isEmpty()){
                    	Coordinate pos = queue.poll();
                        int row = pos.x;
                        int col = pos.y;
                        
                        isVisited[row][col] = true;
                        for (int k = 0; k < 4; k++) {
							Coordinate nextPos = new Coordinate(row + directionX[k], col + directionY[k]);
			                if (!inBound(nextPos, grid)) {
			                    continue;
			                }
			                if(!isVisited[nextPos.x][nextPos.y]){
			                	queue.add(nextPos);
			                }
						}
                    }
                }
            }
        }
        return ans;
    }

	private boolean inBound(Coordinate coor, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
	}
	

}
