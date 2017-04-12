#pragma once
#include	 <cstring>
class Solution {
public:
    unsigned int convert(const char *str, int lpos, int rpos)
    {
        unsigned int reslt = 0;
        unsigned mul_num = 1;
        for(int i = rpos; i>=lpos; i--)
        {
            reslt += mul_num*(str[i] - 48);
            mul_num *= 10;
        }
        return reslt;
    }
    int atoi(const char *str) {
        if(str == 0)
            return 0;
        int size = strlen(str);
        char negative_min[] = "-2147483648";
        if(strcmp(str, negative_min) == 0)  //special cases
            return (int)-2147483648;
        int lpos = 0;
	int reslt;
        while(lpos < size && !(str[lpos] == '-' || str[lpos] == '+' || (str[lpos] > 47 && str[lpos]<58) ))
        {
            lpos++;
        }
        if(lpos == size)
            return 0;
		bool flag = true;  //determine rpos

		if (str[lpos] == '+')
		{
			lpos++;
		}
		else if (str[lpos] == '-')
		{
			lpos++;
			flag = false;
		}
		else
		{
			;
		}
		//determine rpos
		int rpos = lpos;
		while (rpos < size && (str[rpos] > 47 && str[rpos] < 58))
		{
			rpos++;
		}

		rpos--;
        
		if(rpos <= lpos && !(str[rpos] > 47 && str[rpos] < 58))
		{
			return 0;
		}

        //first, determine whether the int is positive or negative
        //for very large number
		if(flag == false && rpos-lpos > 9)
		{
			return -2147483648;
		}
		if (flag && rpos-lpos > 9)
		{
			return 2147483647;
		}
        if(rpos-lpos == 9 && str[lpos] > 50 && flag)
                return 2147483647;
        
		if(rpos-lpos == 9 && str[lpos] > 50 && flag == false)
			return -2147483648;
        
        unsigned tmp = convert(str, lpos, rpos);
        if(flag) //positive value
        {
            if(tmp > 2147483647)
                return 2147483647;
            else 
            {
                reslt = (int)tmp;
                return reslt;
            }
        }
        else //negative value
        {
            if(tmp > 2147483647)
                return  -2147483648;
            else
            {
                reslt = (int)tmp;
                return 0-reslt;
            }
        }
    }
};

