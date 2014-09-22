class Solution {
public:
    void getPermute(vector<vector<int> > &vvi, vector<int> &num, vector<int> &vi, unsigned int iBegin){
        if(vi.size() == num.size()){
            vvi.push_back(vi);
        }
        
        unordered_set<int> map;
        unsigned i = iBegin;
        while(i < num.size()){
            map.insert(num[i]);
            vi.push_back(num[i]);
            getPermute(vvi, num, vi, i+1);
            vi.pop_back();
            while( ++i < num.size() && map.count(num[i]) == 1);
            if(i == num.size())
                return;
            
            swap(num[i], num[iBegin]);
        }
        
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        vector<vector<int> > vvi;
        vector<int> vi;
        getPermute(vvi, num, vi, 0);
        return vvi;
    }
};
