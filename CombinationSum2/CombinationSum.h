class Solution {
public:
    void myFunc(vector<int> &num, int target, unsigned int iLeft, vector<vector<int> > &vvi, vector<int> &vi, int sum){
            while(iLeft < num.size()){
                if(sum == target){
                    vvi.push_back(vi);
                    return;
                }
                if(sum < target){
                    if(sum + num[iLeft] > target)
                        return;
                    vi.push_back(num[iLeft]);
                    myFunc(num, target, iLeft+1, vvi, vi, sum+num[iLeft]);
                    vi.pop_back();
                    while(++iLeft < num.size() && num[iLeft] == num[iLeft-1]);
                }
            }
    }
    
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        vector<vector<int> > vvi;
        if(num.size() == 0){
            return vvi;
        }
        sort(num.begin(), num.end());
        vector<int> vi;
        
        myFunc(num, target, 0, vvi, vi, 0);
        return vvi;
    }
};
