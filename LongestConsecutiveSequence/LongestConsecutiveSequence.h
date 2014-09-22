#pragma once
#include <map>
#include <vector>
using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        int iMax = 1;
        map<int, bool> iimStore;
        
		for (int i = 0; i < num.size(); i++)
		{
			iimStore[num[i]] = false;
		}

		map<int, bool>::iterator it = iimStore.begin();

		while(it != iimStore.end()){
			if ( it->second == true )
			{
				++it;
			} 
			else
			{
				int iCount = 1;
				it->second = true;
				//increment
				int i = it->first;
				map<int, bool>::iterator itMap = iimStore.find(++i);
				while( itMap != iimStore.end() ){
					itMap->second = true;
					iCount++;
					itMap = iimStore.find(++i);
				}

				//decrement
				int j = it->first;
				itMap = iimStore.find(--j);
				while (itMap != iimStore.end())
				{
					itMap->second = true;
					iCount++;
					itMap = iimStore.find(--j);
				}

				if (iCount > iMax)
				{
					iMax = iCount;
				}
			}
		}

        
        return iMax;
    }
};

