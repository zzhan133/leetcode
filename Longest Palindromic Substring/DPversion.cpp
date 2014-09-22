#include	<string>
#include	<vector>
#include	<new>
#include	<iostream>

using namespace std;

class Solution{
	public:
		string longestPalindrome(string s)
		{
			//1. if s is empty or s is a single character, return s
			if(s.size() == 0 || s.size() == 1)
				return s;
			int size = s.size();
			//vector<vector<bool> > string_matrix(size, vector<bool>(size));
			bool** string_matrix = new bool*[size];
			for (int i = 0; i < size; i++)
			{
				string_matrix[i] = new bool[size];
			}
		       for(int i = 0; i<size; i++)
		       {
			       for ( int j = 0; j < size; j += 1 ) {
				       string_matrix[i][j] = false;
			       }
		       }
			//initialize string_matrix[i][i], string_matrix[i][i+1]
				       
		       for ( int i = 0; i < size; i += 1 ) {
			       string_matrix[i][i] = true;
			       if(i+1<size && s[i] == s[i+1])
				       string_matrix[i][i+1] = true; 
		       }
		       //fill out other values pij = true iff p[i+1][j-1] == true and s[i] == s[j]
			    int step = 2;
			    int max_gap = 1;
		       int left_pos = 0;
		       while(step < size)
		       {
			        for ( int i = 0; i < size-step; i += 1 ) {
						int j = i+step;
						if(string_matrix[i+1][j-1] == true && s[i] == s[j])
						{
	   						string_matrix[i][j] = true;	
	   						if(j-i + 1 > max_gap)
						    {
							    max_gap = j-i + 1;
							    left_pos = i;
						    }
						}
				       }
				step++;
				
		       }
		       //find the maximum gap at the string_matrix
		       string rlt = s.substr(left_pos, max_gap);
			   for (int i = 0; i < size; i++)
			   {
				   delete [] string_matrix[i];
			   }
			   delete [] string_matrix;
			   return rlt;
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

