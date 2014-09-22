#include <string>
#include <vector>
using namespace std;

class Solution {
public:
	bool isTwoNum(char a, char b)
	{
		if(a == 49 && ((b > 48 && b < 58) || b == '0'))
			return true;
		if(a == 50 && ((b > 48 && b < 55) || b == '0'))
			return true;
		return false;
	}


	int numDecodings(string s) {
		if(s.size() == 0)
			return 0;
		if(s[0] == '0')
		{
			return 0;
		}
		vector<int> viStore(s.size()+1, 0);
		viStore[0] = 1;
		viStore[1] = 1;
		if(s[s.size() - 1] == '0'){
			viStore[1] = 0;
		}

		int iSize = s.size();
		for(int i = iSize - 2; i >= 0; i--)
		{
			char first = s[i];
			if(first < 49 || first > 57){
				viStore[iSize-i] = 0;
				continue;
			}
			//only consider first
			viStore[iSize-i] = viStore[iSize - i - 1];
			char second = s[i+1];
			//consider two character

			if(isTwoNum(first, second))
			{
				viStore[iSize-i] += viStore[iSize - i -2];
			}
		}

		return viStore[s.size()];

	}
};
