#include	"../../../WordBreak2\\WordBreak2_v2.h"
//#include	"../../../ScrambleString/ScrambleString_v1.h"
#include	<string>
#include	<vector>
#include	<iostream>
#include    <algorithm>

using namespace std;

int main()
{
	string s = "catsanddog";
	unordered_set<string> dict;
	string strArray[] = {"cat", "cats", "and", "sand", "dog"};
	dict.insert(strArray, strArray+5);

	Solution instance;
	vector<string> reslt = instance.wordBreak(s, dict);

	return 0;
}
	
	//vector<int> num(arr, arr+6);
//	sort(arr[0].begin(), arr[0].end());
//	cout<<arr[0]<<endl;

//	string word2("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi");
//	string word2("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
//	string word2; cin >> word2;
//	vector<int> example(arr, arr+3);f
//	string word2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
/*
int arr1[] = { 0,1,0,0,0};
	vector<int> tmp1(arr1, arr1+5);
	int arr2[] = { 1,0,0,0,0 };
	vector<int> tmp2(arr2, arr2+5);
	int arr3[] = {0,0,0,0,0};
	vector<int> tmp3(arr3, arr3+5);

	vector< vector<int> > matrix;
	matrix.push_back(tmp1);

	matrix.push_back(tmp2);

	matrix.push_back(tmp3);

	matrix.push_back(tmp3);
	
	TreeNode* a = new TreeNode(1);
	TreeNode* b = new TreeNode(3);
	TreeNode* c = new TreeNode(2);
	a->left = c;
	a->right = b;
*/

/*
	int arr[] = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};// { 59, 99, 97, 33, 38 , 56, 7, 13, 54, 77, 82, 7, 76, 94, 30};
	vector<int> num(arr, arr+79);
*/
/*
	ListNode* a = new ListNode(1);
	ListNode* b = new ListNode(2);
	ListNode* c = new ListNode(3);
	ListNode* d = new ListNode(4);
	ListNode* e = new ListNode(5);
	a->next = b;
	b->next = c;
	c->next = d;
	d->next = e;
*/

/*
	string a("abcd");
	string b("bcda");
	Solution instance;
	bool bTmp = instance.isScramble(a, b);
	//vector<vector<int> > reslt = instance.permute(example);
	//instance.solveNQueens(8);
//	int i = instance.uniquePathsWithObstacles(matrix);

	

	return 0;
}

*/