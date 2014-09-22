//#include	"../../PalindromePartitioning2\PalindromePartitioning2.h"
#include	"E:\Dropbox\programmer\leetcode\WordLadder2\WordLadder.h"
//#include "d:\Dropbox\programmer\leetcode\WordSearch\WorkSearch_v2.h"
#include	<string>
#include	<iostream>

using namespace std;

int main()
{
//	int arr[] = { 3, 0, -2, -1, 1, 2 };// { 59, 99, 97, 33, 38 , 56, 7, 13, 54, 77, 82, 7, 76, 94, 30};
//	string word2("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi");
//	string word2("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
//	string word2; cin >> word2;
//	vector<int> example(arr, arr+6);
//	string word2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	
//	TreeNode* a = new TreeNode(1);
//	string str;
//	cin >> str;
	//const char *a = " .2e81+6";
	//int arr[] = { 1, 1, 3};
	//int arr1[] = {0,1,2};

	/*vector<int> example(arr, arr + 3);
	vector<int> example1(arr1, arr + 3);
	vector<vector<int> > b;
	b.push_back(example);
	b.push_back(example1);*/
//	string str("DCXXI");
	/*
	ListNode a(1);
	ListNode b(2);
	ListNode c(3);
	ListNode d(4);
	a.next = &b;
	b.next = &c;
	c.next = &d;
	*/

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