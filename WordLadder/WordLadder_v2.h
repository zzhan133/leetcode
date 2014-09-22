#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
	bool isConnected(const string &a, const string &b){
		int iDif = 0;
		for(unsigned i = 0; i < a.size(); i++){
			if(a[i] != b[i]){
				iDif++;
				if(iDif > 1)
					return false;
			}
		}

		if(iDif == 1)
			return true;
		else
			return false;   //How to deal with the situation that a == b?
	}


	bool getAdjLevelQue(unordered_set<string> &dict, vector<string> &qStr, unordered_set<string> &strToEnd){
		vector<string> qStrSwitch;

		for (auto it = qStr.begin(); it != qStr.end(); it++)
		{
			for (auto i = dict.begin(); i != dict.end(); i++)
			{
				if (isConnected(*it, *i))
				{
					qStrSwitch.push_back(*i);
					if(strToEnd.count(*i) == 1)
						return true;
				}
			}
		}
		eraseDict(dict, qStrSwitch);
		swap(qStr, qStrSwitch);
		return false;
	}


	void eraseDict(unordered_set<string> &dict, vector<string> &arr){
		for (auto i = arr.begin(); i != arr.end(); i++)
		{
			dict.erase(*i);
		}
	}

	int ladderLength(string start, string end, unordered_set<string> &dict) {
		int iCount = 3;
		unordered_set<string> strToEnd;
		vector<string> qStr;
		for(auto it = dict.begin(); it != dict.end(); it++){
			bool bEnd =  isConnected(end, *it);
			bool bStart = isConnected(start, *it);
			if(bEnd && bStart)
				return iCount;
			else if (bEnd)
			{
				strToEnd.insert(*it);
			}
				
			else if(bStart){
				qStr.push_back(*it);
			}
		}

		eraseDict(dict, qStr);

		while(!qStr.empty()){
			if(getAdjLevelQue(dict, qStr, strToEnd)){
				return ++iCount;
			}
			else{
				iCount++;
			}
		}

		return 0;


	}
};
