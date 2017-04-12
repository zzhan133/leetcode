#include	<string>
using namespace std;
class Solution {
public:
	bool isSameLetter(char a, char b)
	{
		if(a == b)
		{
			return true;
		}
		else if(isalpha(a) && isalpha(b) && (a-b == 32 || b-a == 32)){
			return true;
		}
		return false;
	}
    bool isPalindrome(string s) {
       int size = s.size();
      if(0 == size)
	     return true;
      int lpos = 0;
      int rpos = size-1;
     while(lpos < rpos)
     {
	     while(lpos <rpos && !isalnum(s[lpos])){
		     lpos++;
	     }
	     while(lpos<rpos && !isalnum(s[rpos])){
			rpos--;
	     }
		 if (lpos == rpos)
			 return true;
	     if(!isSameLetter(s[lpos], s[rpos]))
			     return false;
		 lpos++;
		 rpos--;

     } 
     return true;
    }
};


