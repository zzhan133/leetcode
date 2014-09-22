#pragma once
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        int m = obstacleGrid.size();  //m = 3
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].size(); //n = 1
        if(n == 0)
            return 0;
            
        vector<vector<int> > matrix(m, vector<int> (n, 0));
        
        //the last row
        for(int i = n-2; i >= 0; i-- ){
            if( i == n-2 ){
                if(obstacleGrid[m-1][i] == 0)
                    matrix[m-1][i] = 1;
                else
                    matrix[m-1][i] = 0;
            }
            else{
                if(obstacleGrid[m-1][i] == 1 || matrix[m-1][i+1] == 0){
                    matrix[m-1][i] = 0;
                }
                else{
                    matrix[m-1][i] = 1;
                }
            }
        }
        
        
        
        //the last col
        for(int i = m-2; i >= 0; i--){
            if(i == m-2){
                if( obstacleGrid[i][n-1]){
                    matrix[i][n-1] = 0;
                }
                else
                    matrix[i][n-1] = 1;
            }
            else{
                if(obstacleGrid[i][n-1] == 1 || matrix[i+1][n-1] == 0){
                    matrix[i][n-1] = 0;
                }
                else{
                    matrix[i][n-1] = 1;
                }
            }
        }
        
        
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
				if(obstacleGrid[i][j] == 1){
					matrix[i][j] = 0;
				}
				else
					matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
            }
        }
        return matrix[0][0];
    }
};

