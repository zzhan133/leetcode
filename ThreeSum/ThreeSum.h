#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
	vector<vector<int> > twoSum(vector<int> &num, int target, int pos)
	{
		vector<vector<int> > reslt;
		unsigned lpos = pos;
		unsigned rpos = num.size() - 1;
		if(num[pos] > target)
			return reslt;
		while(lpos < rpos)
		{
			if(num[lpos] + num[rpos] == target)
			{
				vector<int> tmp;
				tmp.push_back(num[lpos]);
				tmp.push_back(num[rpos]);
				reslt.push_back(tmp);
				int tmp_num = num[lpos];
				while(lpos<rpos && num[++lpos] == tmp_num);
				if(lpos == rpos){
					break;
				}
				rpos--;
			}
			else if(num[lpos] + num[rpos] < target)
			{
				lpos++;
			}
			else
			{
				rpos--;
			}
		}
		return reslt;
	}
    vector<vector<int> > threeSum(vector<int> &num) {
        vector<vector<int> > reslt;
		if(num.size() < 3)
			return reslt;
		//1. sort the array
		sort(num.begin(), num.end());
		//iterate the whole array one by one
		for(unsigned int i = 0; i<num.size()-2; i++)
		{
			if(i > 0 && num[i] == num[i-1]) //must exclude i
				continue;
			int target = 0 - num[i];
			vector<vector<int> > tmp = twoSum(num, target, i+1);
			if(tmp.size() != 0)
			{
				for(unsigned j = 0; j<tmp.size(); j++)
				{
					tmp[j].insert(tmp[j].begin(), num[i]);
				}
				reslt.insert(reslt.end(), tmp.begin(), tmp.end());
			}
		}
		return reslt;
    }
};


