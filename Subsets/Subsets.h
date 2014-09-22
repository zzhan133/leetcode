#include <vector>
using namespace std;

class Solution {
public:

	void combine(vector<vector<int> > &_vviResult, vector<int> &_S, vector<int> viCom, int k, int _iBegin){
		if(k == 0){
			_vviResult.push_back(viCom);
			return;
		}


		for(;_iBegin <= _S.size() - k; _iBegin++){
			viCom.push_back(_S[_iBegin]);
			combine(_vviResult, _S, viCom, k-1, _iBegin+1);
			viCom.pop_back();
		}

	}

	vector<vector<int> > subsets(vector<int> &S) {
        	vector<vector<int> > vviResult;
		if(S.size() == 0)
			return vviResult;

		//get combinations from 1 to S.size()
		int iSize = S.size();
		vector<int> viSingle;
		for ( int i = 1; i <= iSize; i += 1 ) {
			combine(vviResult, S, viSingle, i, 0);
		}

		return vviResult;
	}
};

