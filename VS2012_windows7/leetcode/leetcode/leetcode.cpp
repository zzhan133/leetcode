// leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include	"../../../WordLadder2/WordLadder.h"
//#include "d:\Dropbox\programmer\leetcode\WordSearch\WorkSearch_v2.h"

int _tmain(int argc, _TCHAR* argv[])
{
	unordered_set<string> dict;

	string tmp1("hot");
	string tmp2("dot");
	string tmp3("dog");
	string tmp4("lot");
	string tmp5("log");

	dict.insert(tmp1);
	dict.insert(tmp2);
	dict.insert(tmp3);
	dict.insert(tmp4);
	dict.insert(tmp5);

	string start("hit");
	string end("cog");
	Solution instance;
	vector<vector<string> > vvs = instance.findLadders(start, end, dict);

	return 0;
}

