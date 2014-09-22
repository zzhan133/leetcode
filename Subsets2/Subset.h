class Solution {
public:
	void getArrayForTargetLevel(vector<int> &S, vector< vector<int> > &vvi, unsigned uLevel, vector<int> &viTmp, unsigned uBegin){
		if( viTmp.size() == uLevel){
			vvi.push_back(viTmp);
			return;
		}

		unsigned i = uBegin;
		while(i < S.size() ){
			viTmp.push_back( S[i] );
			getArrayForTargetLevel(S, vvi, uLevel, viTmp, i+1);
			viTmp.pop_back();
			while(++i < S.size() && S[i] == S[i-1]){
				;
			}

		}
	}


	vector<vector<int> > subsetsWithDup(vector<int> &S) {
		vector< vector<int> > vvi;

		if( S.size() == 0)
			return vvi;
		sort( S.begin(), S.end() ); 
		unsigned uLevel = 0;
		while(uLevel <= S.size()){
			vector<int> viTmp;
			getArrayForTargetLevel(S, vvi, uLevel, viTmp, 0);
			uLevel++;
		}

		return vvi;

	}
};
