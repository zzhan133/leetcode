#include "stdlib.h"
#include	<string>
class Solution {
public:
    bool isSame(char* haystack, char *needle, int needle_size){
        while(needle_size != 0){
            if(*haystack != *needle){
                return false;
            }
            haystack++;
            needle++;
			needle_size--;
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
		if (hay_size == 0 || hay_size < needle_size)
			return 0;

        char * pcR = NULL; //The returning variable;
        while(hay_size >= needle_size){
            pcR = haystack;
            if(*haystack == *needle){
                if(isSame(haystack, needle, needle_size))
                    return pcR;
            }
            haystack++;
			hay_size--;
        }
		pcR = NULL;
        return pcR;
    }
};

