#include	<string>
class Solution {
public:
    bool isEqual(char *haystack, char *needle, int pos)
    {
        int needle_size = strlen(needle);
        for(int i = 0; i<needle_size; i++)
        {
            if(haystack[pos+i] != needle[i])
                return false;
        }
        return true;
    }
    char *strStr(char *haystack, char *needle) {
		if (haystack == 0 || needle == 0)
			return haystack;
        int hay_size = strlen(haystack);
        int needle_size = strlen(needle);
		if (needle_size == 0)
			return haystack;
		if (hay_size == 0)
			return 0;
        //1. I need to find the position where the letter in heystack is equal to needle[0]
        int pos_runner = 0;
        while(pos_runner+needle_size <= hay_size)
        {
        while(pos_runner+needle_size<=hay_size && haystack[pos_runner] != needle[0])
        {
            pos_runner++;
        }
        if(pos_runner+needle_size > hay_size)
            return 0;
        if(isEqual(haystack, needle, pos_runner))  //now we have haystack[runner_pos] == needle[0]
            return haystack+pos_runner;
        else
            pos_runner++;
        }
        return 0;
    }
};


