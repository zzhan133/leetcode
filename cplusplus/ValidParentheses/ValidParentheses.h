#include <string>
using namespace std;

class Solution {
public:
    bool isPair(char a, char b)  //a is the left part, b must be the right part
    {
        if(a == '(' && b == ')')
		return true;
        if(a == '[' && b == ']')
		return true;
	if(a == '{' && b == '}')
		return true;
	return false;
    }


    	bool isValid(string s) {
        if(0 == s.size() || 1 == s.size()%2)
            return true;

	 //1. the first two chars are valid parenthese
	 char a = s[0];
	 char b = s[1];
	 if(isPair(a,b))
	 {
	 	if(s.size() == 2)
			return true;
	 	string tmp = s.substr(2, s.size()-2);
		return isValid(tmp);
	 }

	 //3. the last two chars are valid parenthese
	 a = s[s.size()-2];
	 b = s[s.size()-1];
	 if(isPair(a,b))
	 {
	 	string tmp = s.substr(0, s.size()-2);
		return isValid(tmp);
	 }
	 //If the string doesn't belong to any situation of the above. Then divide the string into two small pieces.
	unsigned int pos = 0;
	 while(pos < s.size() && (s[pos] == '(' || s[pos] == '[' || s[pos] == '{'))
	{
		pos++;
	}
	 if(pos == s.size() || pos*2 > s.size() )
		 return false;
	
	int l_pos = pos - 1;
	while (pos<s.size() && isPair(s[l_pos],s[pos]))
	{
		pos++;
		l_pos--;
	}
	if(pos == s.size())
		return true;
	if (l_pos == pos - 1)
		return false;
	s.erase(l_pos+1, pos-l_pos-1);
	return isValid(s);
    }
};


