#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    void generate(vector<string> &reslt, int n, int level)
    {
        if(n<level)
            return;
        vector<string> tmp(reslt);
        reslt.clear();
        for(auto it = tmp.begin(); it != tmp.end(); it++){
            string front("(");
            string back(")");
            string tmp1 = front+back+(*it);
            string tmp2 = front+(*it)+back;
            reslt.push_back(tmp1);
            reslt.push_back(tmp2);
            string comp = (*it).substr(0,2);
            string tmp3("()");
            if(comp != tmp3){
                tmp3 = (*it)+tmp3;
                reslt.push_back(tmp3);
            }
        }
        if(n == level)
            return;
        generate(reslt, n, level+1);
        
    }
    vector<string> generateParenthesis(int n) {
        vector<string> reslt;
        if(n<1)
            return reslt;
        reslt.push_back("()");
        if(1 == n)
            return reslt;
        generate(reslt, n, 2);
        return reslt;
        
    }
};

