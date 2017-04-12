#pragma once
#include	<vector>
#include	<climits>
#include	<algorithm>
using namespace std;
class Solution {
public:
    void layerSum(vector<vector<int> > &triangle, int sum, int &max_sum, int layer,  int pos)  //pos is the last layer position
    {
        if(layer == (int)triangle.size())
            return;
        else if(layer+1 == (int)triangle.size())  //have arrived the bottom layer
        {
            int left_val = triangle[layer][pos];
            int right_val = triangle[layer][pos+1];
            int tmp = sum+std::min(left_val, right_val);
            max_sum = std::min(tmp, max_sum);
        }
        else   //in the middle layer
        {
            int left_pos = pos;
            int right_pos = pos+1;
            layerSum(triangle, sum+triangle[layer][left_pos], max_sum, layer+1, left_pos);
            layerSum(triangle, sum+triangle[layer][right_pos], max_sum, layer+1, right_pos);
            
        }
    }
    int minimumTotal(vector<vector<int> > &triangle) {
        int sum = 0;
        int max_sum;
        if(0 == triangle.size())
            return sum;
        sum = triangle[0][0];
        if( 1==triangle.size())
            return sum;
        max_sum = INT_MAX;
        layerSum(triangle, sum, max_sum, 1, 0);
        return max_sum;
    }
};

