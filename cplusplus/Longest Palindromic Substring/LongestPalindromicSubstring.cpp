#include	<string>
#include	<new>
#include	<iostream>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if(s.size() == 0 || s.size() == 1)
            return s;
        //create a string to reverse the original string
        string reverse;
        for(int i = s.size() -1 ; i>=0;i--)
        {
            reverse.push_back(s[i]);
        }
        int num = s.size();
        //create an 2-dymentiional matrix to store the number
        int** p_matrix = new int*[num];
        for(int i = 0; i<num; i++){
            p_matrix[i] =  new int[num];
        }
        for(int i = 0; i<num; i++)
        {
            for(int j = 0; j<num; j++)
            {
                p_matrix[i][j] = 0;
            }
        }
        //1.initialize the first row
        for(int i = 0; i<num; i++){
            if(reverse[0] == s[i] )
            {
                p_matrix[0][i] = 1;
            }
        }
         //2.initialize the first column
        for(int i = 0; i<num; i++){
            if(reverse[i] == s[0] )
            {
                p_matrix[i][0] = 1;
            }
        }

		for (int i = 1; i < num; i++)
		{
			for (int j = 1; j<num; j++)
			{
				if (reverse[i] == s[j])
				{
					p_matrix[i][j] = p_matrix[i - 1][j - 1] + 1;
				}
			}
		}
           
        
        int max_palindromic = 1;
        int row_position = 0;
        for(int i = 0; i<num; i++)
        {
            for(int j = 0; j<num;j++){
                if(p_matrix[i][j] > max_palindromic){
                    max_palindromic = p_matrix[i][j];
                    row_position = j;
                }
            }
        }
        
        string result;
        for(int i = 0; i< max_palindromic; i++){
            result.push_back(s[row_position-i]);
        }
        
        //delete the matrix
        for(int i = 0; i<num; i++){
            delete [] p_matrix[i];
            p_matrix[i] = 0;
        }
        delete [] p_matrix;
        p_matrix = 0;
        return result;
    }
};
int main()
{
	string str("abacdfgdcaba");
	
	string tmp(str,3,3);
	cout << tmp << endl;
	Solution instance;
	cout << instance.longestPalindrome(str) << endl;
	cout << "Hello World!" << endl;


	////numbers limits

	return 0;
}

