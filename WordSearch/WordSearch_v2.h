#include <vector>
#include <string>

using namespace std;

class Solution {
public:
	bool isValidPosition(vector<vector<bool> > &vvb, int nRow, int nCol, char c, vector<vector<char> > &board){
		//Is nRow valid
		if((nRow >= 0 && nRow < (int)vvb.size()) && ( nCol >= 0 && nCol < (int)vvb[nRow].size() ) && ( vvb[nRow][nCol] == false && c == board[nRow][nCol]) )
			return true;
		return false;
	}
	//nRow, nCol is the starting searching points;
	//nPos is the position of the char in word 
	bool myFunc(vector<vector<char> > &board, string &word, vector<vector<bool> > &vvb, int nRow, int nCol, int nPos){
		if(nPos == word.size())
			return true;

		char tmp = word[nPos];
		if(isValidPosition(vvb, nRow, nCol, tmp, board))
			vvb[nRow][nCol] = true;
		else
			return false;
		//four directions
		//left: nRow, nCol-1
		//right: nRow, nCol + 1
		//up: nRow - 1, nCol
		//down: nRow + 1, nCol
		//
		if( myFunc(board, word, vvb, nRow, nCol-1, nPos+1) || myFunc(board, word, vvb, nRow, nCol + 1, nPos+1) || myFunc(board, word, vvb, nRow - 1, nCol, nPos+1) || myFunc(board, word, vvb, nRow + 1, nCol, nPos+1))
			return true;
		else
		{
			vvb[nRow][nCol] = false;
			return false;
		}
		

	}
    
	bool exist(vector<vector<char> > &board, string word) {
 	if(word.size() == 0)
	 	return true;
	unsigned int iRow = board.size();
	if(iRow == 0)
		return false;

	//use a 2-D array to represent the matching history of the board
	vector<vector<bool> > vvb;
	for ( unsigned i = 0; i < iRow; i += 1 ) {
		unsigned uiCol = board[i].size();
		vector<bool> tmp(uiCol, false);
		vvb.push_back(tmp);
	}

	for(unsigned int i = 0; i<board.size(); i++){
		for(unsigned int j = 0; j < board[i].size(); j++){
			if(myFunc(board, word, vvb, i, j, 0))
				return true;
		}
	}
	return false;


    }
};
