#include <string>
#include <unordered_set>


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


	bool getAdjLevelQue(unordered_set<string> &dict, unordered_set<string> &qStr, unordered_set<string> &strToEnd, string &end){
		unordered_set<string> qStrSwitch;

		for(unordered_set<string>::iterator it = qStr.begin(); it != qStr.end(); it++){
			string strTmp = *it;
			for(char i = 'a'; i <= 'z'; i++){
				
				for(unsigned j = 0; j < strTmp.size(); j++){
					char tmp = strTmp[j];
					if( (i == strTmp[j] )){
						continue;
					}
					else{
						
						strTmp[j] = i;
						if(end == strTmp){
							return true;
						}
						else if( dict.count(strTmp) == 1){
							qStrSwitch.insert(strTmp);
							dict.erase(strTmp);
						}
						
						strTmp[j] = tmp;
					}
				}
			}	

		}
		
		swap(qStr, qStrSwitch);
		return false;
	}

	int ladderLength(string start, string end, unordered_set<string> &dict) {
		int iCount = 2;
		unordered_set<string> strToEnd;
		unordered_set<string> qStr;
		
		qStr.insert(start);
		dict.insert(end);

		while(!qStr.empty()){
			if(getAdjLevelQue(dict, qStr, strToEnd, end)){
				return iCount;
			}
			else{
				iCount++;
			}
		}

		return 0;


	}
};

