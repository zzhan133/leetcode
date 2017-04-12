#include <vector>
using namespace std;
class Solution {
public:
    vector< vector<bool> > setBoard(vector< vector<bool> > vvbBoard, int level, int pos){
        //clear row
        vector< vector<bool> > board(vvbBoard);

        for(int i = 0; i<board.size(); i++){
            board[level][i] = true;
        }
        
        
        //clear col
        for(int i = 0; i<board.size(); i++){
            board[i][pos] = true;
        }
        
        //clear diagonal
        int row = level;
        int col = pos;
        while(row > 0 && col > 0){
            board[row-1][col-1] = true;
            row--;
            col--;
         }
         
         
         row = level;
        col = pos;
        while(row > 0 && col+1 < board.size()){
            
            board[row-1][col+1] = true;
            row--;
            col++;
            
         }
         
        row = level;
        col = pos;
        while( row+1 < board.size() && col > 0 ){
            
            board[row+1][col-1] = true;
            row++;
            col--;

         }
         
        row = level;
        col = pos;
        while(row + 1 < board.size() && col + 1 < board.size()){
            board[row+1][col+1] = true;
            row++;
            col++;
         }
         
        board[level][pos] = false;
        return board;
    }
    
    
    void func(vector< vector<bool> > &board, int level, int &iTotal){
        if(level == board.size()){
            iTotal++;
            return;
        }
        
        //choose a place to set Q
        for(int i = 0; i< board.size(); i++){
            if(board[level][i] == false){
                vector< vector<bool> > vvbTmpBoard = setBoard(board, level, i);
                func(vvbTmpBoard, level+1, iTotal);
            }
        }
    }
    
    
    int totalNQueens(int n) {
        vector< vector<bool> > board(n, vector<bool>(n, false) );
        if(n <= 0)
            return 0;
        int iTotal = 0;
        func(board, 0, iTotal);
        return iTotal;
    }
};

