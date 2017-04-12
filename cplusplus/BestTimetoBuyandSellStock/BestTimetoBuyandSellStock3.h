#pragma once
#include <vector>
#include <algorithm> 
#include <iostream>
using namespace std;

class Solution {
public:
    int reverse_maxProfit(vector<int> &prices, int lref, int rref)
    {
        if(rref <= lref)
            return 0;
        int minV = INT_MAX;
        int max = 0;
        for(int i = rref; i>=lref; i--)
        {
            if(minV>prices[i])
            {
                minV = prices[i];
            }
            if(max < prices[i] - minV)
            {
                max = prices[i] - minV;
            }
        }
        return max;
    }
    
    
    int maxProfit(vector<int> &prices, int lref, int rref, int& lpos, int& rpos)
    {
        if(rref <= lref)
            return 0;
        int minV = INT_MAX;
        int max = 0;
        for(int i = lref; i<=rref; i++)
        {
            if(minV>prices[i])
            {
                minV = prices[i];
                lpos = i;
            }
            if(max < prices[i] - minV)
            {
                max = prices[i] - minV;
                rpos = i;
            }
        }
        return max;
    }
    int maxProfit(vector<int> &prices) {
        if(prices.size() == 0 || prices.size() == 1)
            return 0;
        int r_left = 0;
        int r_right = prices.size() - 1;
        int reslt = 0;
        int lpos = 0;
        int rpos = 0;
        reslt = maxProfit(prices, r_left, r_right, lpos, rpos);
        if(reslt == 0)
            return reslt;
		//cout << lpos << " " << rpos << endl;
        int inner_reslt = reverse_maxProfit(prices, lpos+1, rpos-1);
        int a = 0;
        int b = 0;
        int external_reslt = std::max(maxProfit(prices, r_left, lpos-1,a,b), maxProfit(prices, rpos+1, r_right, a,b));
        return reslt + std::max(inner_reslt, external_reslt);
    }
};

