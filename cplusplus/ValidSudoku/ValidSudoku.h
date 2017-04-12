
#include <vector>
using namespace std;
class Solution {
public:
    bool element(vector<vector<char> > &board, int iUpRow, int iUpCol, int iDnRow, int iDnCol ){
        vector<bool> check(9, false);
        for(int i = iUpRow; i<=iDnRow; i++)
        {
            for(int j = iUpCol; j <= iDnCol; j++)
            {
                char cTmp = board[i][j];
                if(cTmp == '.')
                    continue;
                if(cTmp-49 < 0 ||cTmp-49 > 8)
                    return false;
                if(check[cTmp-49] == true)
                    return false;
                else{
                    check[cTmp-49] = true;
                }
                
            }
        }
    }
    bool isValidSudoku(vector<vector<char> > &board) {
        if(board.size() != 9)
            return false;
            
        for(int i = 0; i<9; i++){
            if(board[i].size() != 9){
                return false;
            }
        }
        
        //rows
        for(int i = 0; i < board.size() ; i++){
            if(element(board, i, 0, i, 8) == false)
                return false;
        }
        //cols
        for(int i = 0; i < 9 ; i++){
            if(element(board, 0, i, 8, i) == false)
                return false;
        }
        //blocks
        for(int i = 0; i < 3; i++)
        {
            int iRow = i*3;
            for(int j = 0; j<3; j++)
            {
                int iCol = j*3;
                if(element(board, iRow, iCol, iRow+2, iCol+2) == false)
                    return false;
            }
        }
        
        return true;
        
    }
};

