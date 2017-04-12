#pragma once

#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int nRows) {
        int size = (int)s.size();
        string reslt;
        if(size == 0)
             return reslt;
	if(nRows == 1)
		return s;
	vector<string> Strings(nRows);
	if(nRows == 2)
	{
		string tmp;
		for(int i = 0; i<size; i+=2)
		{
			tmp.push_back(s[i]);
		}
		for(int i = 1; i<size;i+=2)
		{
			tmp.push_back(s[i]);
		}
		return tmp;
	}
	int gap = 2*nRows-2;
	for(int i = 0; i<size; i += gap)
	{
		Strings[0].push_back(s[i]);
	}
	for(int i = 1; i<nRows-1; i++)
	{
		//char for 1 to nRows -2.
		//There are two chars needs to add
		int inner_gap = gap-2*i;
		for(int j= i; j < size; j += 2*i)
		{
			Strings[i].push_back(s[j]);
			j = j + inner_gap;
			if(j<size)
				Strings[i].push_back(s[j]);
							
		}


	}
	for(int i = nRows-1; i < size; i+=gap)
	{
		Strings[nRows-1].push_back(s[i]);
	}

	for(int i = 0; i<nRows; i++)
	{
		reslt.append(Strings[i]);
	}
		return reslt;
    }
};

