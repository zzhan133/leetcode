#include <vector>
#include <string>
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
    
    void func(vector< vector<bool> > &board, int level, vector<vector<string> > &vvstr){
        if(level == board.size()){
            //convert bool to string
            vector<string> vstr;
            for(int i = 0; i< board.size(); i++){
                string str;
                for(int j=0; j<board.size(); j++){
                    if(board[i][j] == true){
                        str.push_back('.');
                    }
                    else{
                        str.push_back('Q');
                    }
                }
                vstr.push_back(str);
            }
            vvstr.push_back(vstr);
            return;
        }
        
        //choose a place to set Q
        for(int i = 0; i< board.size(); i++){
            if(board[level][i] == false){
                vector< vector<bool> > vvbTmpBoard = setBoard(board, level, i);
                func(vvbTmpBoard, level+1, vvstr);
            }
        }
    }
    
    vector<vector<string> > solveNQueens(int n) {
		vector< vector<bool> > board(n, vector<bool>(n, false) );
        vector<vector<string> > vvstr;
        if(n <= 0)
            return vvstr;
        func(board, 0, vvstr);
        return vvstr;
    }
};

