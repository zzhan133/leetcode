class Solution {
public:
	void word(string &s, unordered_set<string> &dict, vector<string> &vstrR, string strSi, int iBegin){
		if(iBegin == s.size()){
			vstrR.push_back(strSi);
			return;
		}
		else{
			for(int i = 1; i <= s.size() - iBegin; i++){
				string strTmp = s.substr(iBegin, i);
				if(dict.count(strTmp) == 1){
					string str(strSi);
					if(str.size() == 0)
					{
						str = strTmp;
					}
					else
						str = strSi + " " + strTmp;
					word(s, dict, vstrR, str, iBegin+i);
				}
			}
			return;
		}
	}

    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        vector<string> vstrR;  //The variable is used for return
        string strSi; //This variable is used to store the seperated word
        
        word(s, dict, vstrR, strSi, 0);
	return vstrR;
    }
};

