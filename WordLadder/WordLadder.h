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

	void getAdjLevelQue(string str, unordered_set<string> &dict,  set<string> &bRecord, queue<string> &qStr){
		qStr.clear();
		for(auto it = dict.begin(); it != dict.end(); it++){
		   if( isConnected(start, *it) && bRecord.count(*it) == 0){
			   qStr.push(*it);
			   bRecord.insert[*it];
		   }
	   }

	}

	bool isConnectedToEnd(set<string> &strToEnd,  queue<string> &qStr){
		for(auto it = qStr.begin(); it != qStr.end(); it++){
			if(strToEnd.count(*it) == 1)
				return true;
		}
		return false;
	}

    int ladderLength(string start, string end, unordered_set<string> &dict) {
 		
	   //establish the adjacent List for each word
	   set<string> bRecord;
	   queue<string> qStr;
	   //get the word connected to the End string
	   	set<string> strToEnd;
	   	for(auto it = dict.begin(); it != dict.end(); it++){
		   if( isConnected(end, *it)){
			   strToEnd.push(*it);
		   }
		}

	   
	   //1. The first level
	   getAdjLevelQue(start, dict, bRecord, qStr);

		while(!qStr.empty()){
			if(isConnectedToEnd(strToEnd, qStr)){
		   		return iCount;
	   		}
	   		else{
				iCount++;
		   		swap(qStr, qStrSwitch);

	   		}
		}
	return 0;
    }
};
