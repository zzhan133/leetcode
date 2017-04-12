// leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
#include <cmath>
#include <climits>
#include <map>
#include <algorithm>
#include <set>
#include <stack>
#include <queue>
#include <limits.h>
#include <functional>

//#include "WorkSearch_v2.h"

using namespace std;


/*
 * Definition for singly-linked list.
 */ struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

 struct TreeNode {
	 int val;
	 TreeNode *left;
	 TreeNode *right;
	 TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 
 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 class Solution {
 public:
	 string simplifyPath(string path) {
		 stack<char> myPath;
		 int i = 0;
		 while(i < path.size()){
			 if(myPath.empty() && path[i] != '/'){
				break;
			 }
			 if(myPath .size() != 0 && path[i] == '.'){
				 if(myPath.top() == '/' && path[i+1] != '.'){
					 myPath.pop();
				 }
				 else if(myPath.top() == '/' && path[i+1] == '.'){
					 myPath.push(path[i]);
				 }
				 else if(myPath.top() == '.'){
					 myPath.pop();
					 if(myPath.size() == 0)
						 break;
					 myPath.pop();
					 while (myPath .size() != 0 && myPath.top() != '/' )
					 {
						 myPath.pop();
					 }
					 if (myPath.size() != 0)
					 {
						 myPath.pop();
					 }
				 }
			 }
			 else{
				 if (path[i] == '/' && myPath.size() != 0 && myPath.top() == '/')
				 {
					 ;
				 }
				 else
					 myPath.push(path[i]);
				 
			 }
			 i++;
		 }

		 string str = "";
		 if(myPath.empty() || (myPath.size() == 1 && myPath.top() == '/'))
		 {
			 str += "/";
			 return str;

		 }		

		 myPath.pop();

		 while(myPath.size() != 0){
			 char tmp = myPath.top();
			 str.insert(str.begin(), tmp);
			 myPath.pop();
		 }

		 return str;

	 }
 };
int _tmain(int argc, _TCHAR* argv[])
{
	//Test case
	


	Solution instance;

	string strArr[] = {"/..","/.....hidden/", "///",  "/.../", "/path/", "/a/./b/../../c/"};

	int arr[] = {2,1,5,6,2,3};
//	int arr[] = {2,4,1};
	vector<int> vi(arr, arr+6);

	int myNum = INT_MIN;
	for(int i = 0; i<6; i++){
		cout<<strArr[i]<<" -> "<< instance.simplifyPath(strArr[i])<<endl;

	}
//	vector<vector<int> > bR = instance.combinationSum2(vi, 1);
//	vector< vector<int> > vvi = instance.subsetsWithDup(vi);
	//printf("%u\n",&tmp);

	return 0;

}

