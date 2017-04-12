#pragma once
#include <vector>
using namespace std;
class Solution {
public:
    void localMin(vector<int> &prices, int& min, unsigned int& index)
    {
        for(; index<prices.size(); index++)
        {
            if(prices[index] > prices[index-1])
                break;
        }
        min = prices[index-1];
    }
    
    void localMax(vector<int> &prices, int& max, unsigned int& index)
    {
        for(; index<prices.size(); index++)
        {
            if(prices[index] < prices[index-1])
                break;
        }
        max = prices[index-1];
    }
    int maxProfit(vector<int> &prices) {
        if(prices.size() == 0 || prices.size() == 1)
            return 0;
        
        int local_max = INT_MIN;
        int max = 0;
        unsigned i = 1;
        int local_min = prices[0];
        while(i<prices.size())
        {
            localMin(prices, local_min, i);
            if(i == prices.size())
            {
                break;
            }
			localMax(prices, local_max, i);
            max = max + local_max-local_min;
            ++i;
        }
        return max;
    }
};

