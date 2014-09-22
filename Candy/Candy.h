#pragma once
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int candy(vector<int> &ratings) {
        int reslt = 0;
        if(ratings.size() == 0)
            return reslt;
		vector<int> candynum(ratings.size(), 1);
        for(int i = 1; i<(int)ratings.size(); i++)
        {
            if(ratings[i] > ratings[i-1])
			{
				candynum[i] = candynum[i-1] + 1;
            }
			/*if (ratings[i] == ratings[i - 1] && ratings[i - 1] != 1)
			{
				candynum[i] = candynum[i-1];
			}*/
        }
		for (int i = (int)ratings.size() - 2; i >= 0; i--)
		{
			if (ratings[i] > ratings[i + 1] && candynum[i] <= candynum[i+1])
			{
				candynum[i] = candynum[i + 1] + 1;
			}
			/*if (ratings[i] == ratings[i + 1] && ratings[i + 1] != 1)
			{
				candynum[i] = candynum[i + 1];
			}
			*/
		}
		//calculate the sum
		for (unsigned i = 0; i < candynum.size(); i++)
		{
		//	cout << candynum[i] << " ";
			reslt += candynum[i];
		}
		//cout << endl;
        return reslt;
    }
};

