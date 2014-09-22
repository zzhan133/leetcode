#pragma once
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
	bool IsPalindrome(string &s, int left, int right)
	{
		while (left <= right)
		{
			if (s[left++] != s[right--])
				return false;
		}
		return true;
	}
	void addElement(string s, vector<vector<string> > &reslt)
	{
		if (reslt.size() == 0)
		{
			vector<string> tmp;
			tmp.push_back(s);
			reslt.push_back(tmp);
			return;
		}
		for (unsigned i = 0; i<reslt.size(); i++)
		{
			reslt[i].insert(reslt[i].begin(), s);
		}
	}
	vector<vector<string>> partition(string s) {
		vector<vector<string> > reslt;
		if (s.size() == 0)
			return reslt;
		unsigned left = 0;
		unsigned right = s.size() - 1;
		for (unsigned i = 0; i < s.size(); i++)
		{
			if (IsPalindrome(s, (int)left, (int)i))
			{
				string str = s.substr(left, i - left + 1);
				if (s.size() == 1)
				{
					vector<string> strArray;
					strArray.push_back(str);
					reslt.push_back(strArray);
					return reslt;
				}
				string remainder = s.substr(i + 1, right - i);
				vector<vector<string> > tmp = partition(remainder);
				addElement(str, tmp);
				reslt.insert(reslt.end(), tmp.begin(), tmp.end());
			}
		}
		return reslt;
	}
};

