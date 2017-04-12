class Solution {
public:
    void myFunc(vector<int> &candidates, int target, int iLeft, vector<vector<int> > vvi, int iSum, vector<int> vi){
	
	while(iLeft < candidates.size() && iSum <= target){

		if(iSum == target){
			vvi.push_back(vi);
			return;
		}
		if(iSum < target){

			vi.push_back(candidates[iLeft]);
			myFunc(candidates, target, iLeft, vvi, iSum + candidates[iLeft], vi);
			vi.pop_back();
			while( ++iLeft < candidates.size() && candidates[iLeft] == candidates[iLeft-1]);

		}
	}

	
    }
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
	    vector<vector<int> > vvi;
	    if(candidates.size() == 0){
		    return vvi;
	    }

	    vector<int> vi;
	    myFunc(candidates, target, 0, vvi, 0, vi);
	    return vvi;
        
    }
};
