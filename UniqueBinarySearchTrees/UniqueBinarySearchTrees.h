#pragma once
#include	<vector>
using namespace std;
class Solution {
public:
    int numTrees(int n) {
        vector<int> viCount(n+1, 0);
        viCount[0] = 1;
        viCount[1] = 1;
        for(unsigned ui = 2; ui < viCount.size(); ui++){
            for(unsigned uiDivide = 0; uiDivide < ui; uiDivide++){
                viCount[ui] += viCount[ui-1-uiDivide] * viCount[uiDivide];
            }
        }
        return viCount[n];
    }
};

