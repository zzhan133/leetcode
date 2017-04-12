#pragma once
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	int minCut(string s) {
		int len = s.size();
		vector<int> D(len+1);
		vector<vector<bool> > P(len, vector<bool>(len, false));
		//the worst case is cutting by each char  
		for (int i = 0; i <= len; i++)
			D[i] = len - i;
		for (int i = len - 1; i >= 0; i--){
			for (int j = i; j < len; j++){
				if (s[i] == s[j] && (j - i<2 || P[i + 1][j - 1])){
					P[i][j] = true;
					D[i] = min(D[i], D[j + 1] + 1);
				}
			}
		}
		return D[0] - 1;
	}
};

/*		for (int i = 1 ; i < (int)s.size(); i++)
		{
			for (int j = 0; j+ i< (int)s.size(); j++)
			{
				if (arr[j][i + j] != -1)
					continue;
				//calcute the value of arr[j][i+j]
				/*
				if (IsPalindrome(s, j, i+j))
				{
					arr[j][i + j] = 0;
				}
				
//				else
				{
					int minC = INT_MAX;
					for (int k = j; k < i+j; k++)  //k is the 
					{
						int tmpNum = arr[k + 1][i + j] + arr[j][k] + 1;
						if (tmpNum == 1)
						{
							minC = tmpNum;
							break;
						}
						minC = std::min(minC, tmpNum);
						
					}
					arr[j][i + j] = minC;
				}
			}
		}

		int answer = arr[0][s.size() - 1];

		for (unsigned i = 0; i < s.size(); i++)
		{
			delete [] arr[i];
		}
		delete[] arr;
		return answer;
	}
*/	
	/*
	int minCut(string s) {
		if (s.size() == 0)
			return 0;
		if (IsPalindrome(s, 0, (int)s.size() - 1))
		{
			return 0;
		}
		int minC = INT_MAX;
		for (int i = 0; i<(int)s.size() - 1; i++)
		{
			if (IsPalindrome(s, 0, i))
			{
				string remainder = s.substr(i + 1, (int)s.size() - i - 1);
				int tmp = 1 + minCut(remainder);
				minC = std::min(tmp, minC);
			}
		}
		return minC;
	}

	*/


/*    int minCut(string s) {
if (s.size() == 0)
return 0;
if (IsPalindrome(s, 0, (int)s.size() - 1))
{
return 0;
}
int minC = INT_MAX;
for (int i = 0; i<(int)s.size() - 1; i++)
{
if (IsPalindrome(s, 0, i))
{
string remainder = s.substr(i + 1, (int)s.size() - i - 1);
int tmp = 1 + minCut(remainder);
minC = std::min(tmp, minC);
}
}
return minC;
}
*/

/*
int leftNum = -1;
int rightNum = -1;
if (leftindex != 0)
{
string leftstr = s.substr(0, leftindex);
leftNum = minCut(leftstr);
}
if (rightindex + 1 != s.size())
{
string rightstr = s.substr(rightindex + 1, s.size() - rightindex - 1);
rightNum = minCut(rightstr);
}
return leftNum + 1 + rightNum + 1;
*/