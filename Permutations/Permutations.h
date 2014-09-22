#pragma  once
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	void permutation(vector<vector<int> > &_vviArr, vector<int> _viSt, vector<int> &num, int iIndex)
	{
		if(_viSt.size() == num.size()){
			_vviArr.push_back(_viSt);
			return;
		}

		for(unsigned ui = iIndex; ui<num.size(); ui++){
			if (ui != iIndex && num[ui] == num[ui-1])
			{
				continue;
			}
			std::swap(num[iIndex], num[ui]);
			_viSt.push_back(num[iIndex]);
			permutation(_vviArr, _viSt, num, iIndex+1);
			_viSt.pop_back();
			std::swap(num[iIndex], num[ui]);
		}
	}

   vector<vector<int> > permute(vector<int> &num) {
      vector<vector<int> > vvArr;
      if(num.size() <= 0)
		return vvArr;
	  sort(num.begin(),num.end());
      vector<int> viTmp;
      permutation(vvArr, viTmp, num, 0);

      return vvArr;
        
   }
};

