#include <vector>
using namespace std;
class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        int row = matrix.size();
        if(row == 0)
            return;
        int col = matrix[0].size();
        //determine if the first row has 0. If yes, set all the elements to 0, but the position which contains 0 set 1; if no 
        int backup = matrix[0][0];


		bool row_zero = false;
		for (int i = 0; i<col; i++)
		{
			if (matrix[0][i] == 0)
			{
				row_zero = true;
				break;
			}
		}
		bool col_zero = false;
		for (int i = 0; i<row; i++)
		{
			if (matrix[i][0] == 0)
			{
				col_zero = true;
				break;
			}
		}

	//iterate from (1,1) to the end
	for(int i = 0; i<row;i++)
	{
		for(int j = 0; j<col;j++){
			if(matrix[i][j] == 0)
			{
				matrix[0][j] = 0;
				matrix[i][0] = 0;
			}
				
		}
	}

	//deal with the col
	for(int i=1; i<col; i++)
	{
		if(matrix[0][i] == 0)
		{
			for(int j = 1; j<row; j++){
				matrix[j][i] = 0;
			}
		}
	}

	for(int i=1; i<row; i++)
	{
		if(matrix[i][0] == 0)
		{
			for(int j = 1; j<col; j++){
				matrix[i][j] = 0;
			}
		}
	}
    

	if (row_zero){

		for (int i = 0; i < col; i += 1) {
			matrix[0][i] = 0;
		}
	}

	if (col_zero){

		for (int i = 0; i < row; i += 1) {
			matrix[i][0] = 0;
		}
	}
    }
};


