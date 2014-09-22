class Solution {
public:
    bool isAna(vector<int> _vi, string _str){
        	for(int i = 0; i<_str.size(); i++)
		{
			_vi[_str[i]-97]--;
		}
		for(int i = 0; i<_str.size(); i++)
		{
			if(_vi[_str[i]-97] != 0)
				return false;
		}
		return true;
    }
    bool ana(vector<string> &_strs, string _str, int _index, vector<bool> &vbIndex){
        bool bResult = false;
	vector<int> vi(26, 0);
	for(int i = 0; i<_str.size(); i++)
	{
		vi[_str[i]-97]++;
	}
        for(int i = _index; i < _strs.size(); i++){
            if(vbIndex[i])
                continue;
	    if(_str.size() != _strs[i].size())
		    continue;
            if(isAna(vi, _strs[i])){
                vbIndex[i] = true;
                bResult = true;
            }
        }
        return bResult;
    }
    vector<string> anagrams(vector<string> &strs) {
        vector<string> vstrResult;
        if(strs.size() == 0)
            return vstrResult;
        vector<bool> vbIndex(strs.size(), false);
        for(unsigned ui = 0; ui<strs.size(); ui++){
	    if(vbIndex[ui])
		    continue;
            string strTmp = strs[ui];
            if(ana(strs, strTmp, ui+1, vbIndex)){
                vbIndex[ui] = true;
            }
        }
        for(unsigned ui = 0; ui<strs.size(); ui++){
		if(vbIndex[ui])
			vstrResult.push_back(strs[ui]);
	}
	return vstrResult;
    }
};

