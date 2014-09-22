#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    void getParenthesis(vector<string> &_vstrResult, string _str, int _iLeft, int _iRight)
    {
        if(_iLeft == 0 && _iRight == 0)
        {
            _vstrResult.push_back(_str);
			
        }
        if(_iLeft > 0)
        {
            getParenthesis(_vstrResult, _str+'(', _iLeft-1, _iRight);
        }
        if(_iRight > 0 && _iLeft < _iRight)
        {
            getParenthesis(_vstrResult, _str+')', _iLeft, _iRight-1);
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> vstrResult;
        if(n <= 0)
            return vstrResult;
        int iLeftRemain = n;
        int iRightRemain = n;
        string str("");
        getParenthesis(vstrResult, str, n, n);
        return vstrResult;
    }
};

