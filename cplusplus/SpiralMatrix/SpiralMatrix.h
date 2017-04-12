#pragma once
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        vector<int> reslt;
        int m = matrix.size();
        if(m == 0)  //m rows
            return reslt;
        int n = matrix[0].size();
        if(n == 0)  //n columns
            return reslt;
        int row_begin = 0;
        int row_end = m-1;
        int col_begin = 0;
        int col_end = n-1;
        while(row_begin <= row_end && col_begin <= col_end)
        {
            //push_back sigle circle into the result vector
            //The order is row, column, row(reverse), column(reverse)
            //1. normal sequence to the beginning row  //row parameter is fixed: row_begin
            for(int i = col_begin; i <= col_end; i++)
            {
                reslt.push_back(matrix[row_begin][i]);
            }
            
            //2. sequence to row  //column parameter is fixed:col_end
            for(int j = row_begin+1; j <= row_end; j++)
            {
                reslt.push_back(matrix[j][col_end]);
            }
            
             //3. reverse sequence to the end row  //row parameter is fixed;row_end
            for(int j = col_end-1; j >=  col_begin; j--)
            {
                reslt.push_back(matrix[row_end][j]);
            }
            
            //4. reverse sequence to row  //column parameter is fixed: col_begin
            for(int j = row_end-1; j >= row_begin+1; j--)
            {
                reslt.push_back(matrix[j][col_begin]);
            }
            row_begin++;
            row_end--;
            col_begin++;
            col_end--;
        }
        return reslt;
    }
};

