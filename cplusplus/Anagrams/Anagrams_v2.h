#pragma once
#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) 
    {
	vector<string> vstrResult;
	if(strs.size() == 0)
	    return vstrResult;

	int iSize = (int)strs.size();

	map<string,vector<int> > mStore;
	for(int i = 0; i<iSize; i++){
		string strTmp = strs[i];
		sort(strTmp.begin(), strTmp.end());
		mStore[strTmp].push_back(i);
	}

    map<string, vector<int> >::iterator mapIt = mStore.begin();
    while(mapIt != mStore.end()){
        if(mapIt->second.size() > 1){
            for(unsigned i = 0; i<mapIt->second.size(); i++)
                vstrResult.push_back(strs[mapIt->second[i]]);
        }
        mapIt++;
    }
    
	return vstrResult;
    }
};



