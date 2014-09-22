#include <string>
#include <vector>
#include <algorithm>
using namespace std;
  


class Solution {
public:
    //judge if two strings are anagrams
 	bool isAna(string &_str1, string &_str2){
		vector<int> _vi(26, 0);

        for(int i = 0; i<_str1.size(); i++)
		{
			_vi[_str1[i]-97]++;
			_vi[_str2[i]-97]--;
		}
		for(int i = 0; i<_str1.size(); i++)
		{
			if(_vi[i] != 0)
				return false;
		}
		return true;
   	 }
    
    vector<string> anagrams(vector<string> &strs) 
	{
	vector<string> vstrResult;
        //convert all the strings to integers
	vector<int> viInt(strs.size(), 0);
	for(int i = 0; i<strs.size(); i++){
		for(int j = 0; j<strs[i].size(); j++){
			viInt[i] += strs[i][j];
		}
	}

	//index for ana
	vector<bool> vbIndex(strs.size(), false);

	//find out anagrams
	for(unsigned i = 0; i<strs.size(); i++){
		if(vbIndex[i] == true)
			continue;
		for(unsigned j = i+1; j<strs.size(); j++){
			if(viInt[i] == viInt[j] && strs[i].size() == strs[j].size() && isAna(strs[i], strs[j]) ){
				vbIndex[i] = true;
				vbIndex[j] = true;
			}
		}
	}

	for(unsigned ui = 0; ui<strs.size(); ui++){
		if(vbIndex[ui])
			vstrResult.push_back(strs[ui]);
	}
	return vstrResult;
    }
};

