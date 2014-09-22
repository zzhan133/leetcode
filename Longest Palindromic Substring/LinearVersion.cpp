#include	<string>
#include	<vector>
#include	<new>
#include	<iostream>

using namespace std;

class Solution{
	public:
		string longestPalindrome(string s)
		{
			//1. if s is empty or s is a single character, return s
			if(s.size() == 0 || s.size() == 1)
				return s;
			int max_shift = 1;
			int left_pos = 0;
			//2. consider the odd length palindrome  time complexity N*N
			for(int i = 0; i<s.size(); i++)
			{
			 	int shift_pos = 1;
				if(i-max_shift/2 < 0 || i+max_shift/2 > s.size() || s[i-max_shift/2] != s[i+max_shift/2])
					continue;
				while(i-shift_pos >= 0 && i+shift_pos < s.size() && s[i-shift_pos] == s[i+shift_pos])
				{
					shift_pos++;
				}
				if(shift_pos*2-1>max_shift)
				{
					max_shift = shift_pos*2-1;
					left_pos = i-shift_pos+1;
				}

			}
			//3.consider the even length palindrome: time complexity: N*N
			int size = s.size();
			for(int i = 0; i<size-1; i++)
			{
				if(i-max_shift/2 < 0 || i+1+max_shift/2 > size || s[i] != s[i+1] || s[i-max_shift/2] != s[i+1+max_shift/2])
					continue;
				int shift_pos = 1;
				while(i-shift_pos >= 0 && i+shift_pos+1 < size && s[i-shift_pos] == s[i+1+shift_pos])
				{
					shift_pos++;
				}
				if(shift_pos*2>max_shift)
				{
					max_shift = shift_pos*2;
					left_pos = i-shift_pos+1;
				}

			}

			string rlt = s.substr(left_pos, max_shift);
			return rlt;
		}
};

int main()
{
	string str("abacdfgdcabbbbbba");
	
	Solution instance;
	cout << instance.longestPalindrome(str) << endl;
	cout << "Hello World!" << endl;


	////numbers limits

	return 0;
}


