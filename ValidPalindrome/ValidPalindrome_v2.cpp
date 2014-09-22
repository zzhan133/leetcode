#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>
#include <ctype.h>


using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
 	if(s.size() == 0)
	 return true;
	unsigned start = 0;
	unsigned end = s.size() - 1;
	while(start < end){
		while(start < end && !isalnum(s[start])){
			start++;
		}
		while(start < end && !isalnum(s[end])){
			end--;
		}
		if(start == end)
			break;
		if( tolower(s[start]) != tolower(s[end]) ){
			return false;
		}
		start++;
		end--;


	}
	return true;
    }
};

#include	<stdlib.h>

/* 
 * ===  FUNCTION  ======================================================================
 *         Name:  main
 *  Description:  
 * =====================================================================================
 */
	int
main ( int argc, char *argv[] )
{
	Solution instance;
	string str("A man, a plan, a canal: Panama");
	string str2("race a car");
	bool a = instance.isPalindrome(str);
	bool b = instance.isPalindrome(str2);
	cout<<"a: "<<a<<endl;
	cout<<"b: "<<b<<endl;
	return 0;
}				/* ----------  end of function main  ---------- */
