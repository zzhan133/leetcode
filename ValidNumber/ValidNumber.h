#include <string>
class Solution {
public:
	bool isPointNum(const char *s, int lpos, int rpos)
	{
		if (rpos < lpos)
			return false;
		if (s[rpos] == '.')
			return isOnlyNumber(s, lpos, rpos - 1);
		if (s[lpos] == '.')
			return isOnlyNumber(s, lpos+1, rpos);
		int e_pos = -2;
		for (int i = lpos; i <= rpos; i++)
		{
			if (s[i] == '.')
			{
				e_pos = i;
				return isOnlyNumber(s, lpos, e_pos - 1) && isOnlyNumber(s, e_pos + 1, rpos);
			}
		}
		return isOnlyNumber(s, lpos, rpos);
	}
	bool isOnlyNumber(const char *s, int lpos, int rpos)
	{
		if (rpos < lpos)
			return false;
		while (lpos <= rpos && (s[lpos]>47 && s[lpos]<58))
		{
			lpos++;
		}
		if (lpos>rpos)
			return true;
		else
			return false;
	}
	bool isOnlyNumberWithSign(const char *s, int lpos, int rpos)
	{
		if (s[lpos] == '+' || s[lpos] == '-')
			return isOnlyNumber(s, lpos + 1, rpos);
		return isOnlyNumber(s, lpos, rpos);

	}
	bool isNumberWithoutSign(const char *s, int lpos, int rpos)
	{
		if (rpos < lpos)
			return false;
		int e_pos = -1;
		for (int i = lpos; i <= rpos; i++)
		{
			if (s[i] == 'e')
			{
				e_pos = i;
				return isPointNum(s, lpos, e_pos - 1) && isOnlyNumberWithSign(s, e_pos + 1, rpos);
			}
		}
		//no 'e' in s
		return isPointNum(s, lpos, rpos);
	}
	bool isSignedNumber(const char *s, int lpos, int rpos)  //rpos != lpos
	{
		if (s[lpos] == '+' || s[lpos] == '-')
		{
			return isNumberWithoutSign(s, lpos + 1, rpos);
		}
		else
			return isNumberWithoutSign(s, lpos, rpos);
	}

	bool isNumber(const char *s) {
		if (0 == s)
			return false;
		int size = strlen(s);
		if (0 == size)
			return false;
		int lpos = 0;
		while (lpos<size && s[lpos] == ' ')
		{
			lpos++;
		}
		if (lpos == size)
			return false;
		int rpos = size - 1;
		while (s[rpos] == ' ') //lpos must point a non-empty char
		{
			rpos--;
		}
		//deal with .
		if (lpos == rpos)
		{
			if (s[lpos]>47 && s[lpos]<58)
				return true;
			return false;
		}
//////////////////////////////////////////////////////////////////////////////////////////the code above is OK

		return isSignedNumber(s, lpos, rpos);
	}
};

