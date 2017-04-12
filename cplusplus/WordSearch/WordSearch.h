
class Solution {
public:
     bool search(vector<vector<char> > &board, string word, int iRow, int iCol, vector< vector<bool> > &vvbStore) {
	      if(word.size() == 0)
	       return true;


       if(iRow < 0 || iRow >= board.size())
	       return false;
       if(iCol < 0 || iCol >= board[iRow].size())
	       return false;
      
      

       if(word[0] == board[iRow][iCol] && vvbStore[iRow][iCol] == false){
	        string strTmp = word.substr(1, word.size()-1);
	        vvbStore[iRow][iCol] = true;
		if(search(board, strTmp, iRow+1, iCol, vvbStore) || search(board, strTmp, iRow-1, iCol, vvbStore)
						||search(board, strTmp, iRow, iCol-1, vvbStore)||search(board, strTmp, iRow, iCol+1, vvbStore))
					return true;
		else{
		    vvbStore[iRow][iCol] = false;
		}
       }
	return false;
    }	
    void generateStore(vector<vector<char> > &board, vector< vector<bool> > &vvbStore){
        for(unsigned ui = 0; ui<board.size(); ui++){
            vector<bool> vbTmp(board[ui].size() , false);
            vvbStore.push_back(vbTmp);
        }
    }
    bool exist(vector<vector<char> > &board, string word) {
	  if(word.size() == 0)
		  return true;
	int iRow = board.size();
	
	vector< vector<bool> > vvbStore;
	generateStore(board, vvbStore);
	
       for(int ui = 0; ui<iRow; ui++){
	       int iCol = board[ui].size();
	       for(int uj = 0; uj<iCol; uj++){
			if(word[0] == board[ui][uj])
			{
			    
			    vvbStore[ui][uj] = true;
				string strNew = word.substr(1, word.size()-1 );
				if(search(board, strNew, ui+1, uj, vvbStore) || search(board, strNew, ui-1, uj, vvbStore)
						||search(board, strNew, ui, uj-1, vvbStore)||search(board, strNew, ui, uj+1, vvbStore))
					return true;
				else{
				    vvbStore[ui][uj] = false;
				}

			}
	       }
       }
      return false; 
    }
};


