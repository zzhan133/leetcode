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
//#include "WorkSearch_v2.h"

using namespace std;


/*
 * Definition for singly-linked list.
 */ struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
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
	ListNode *reverseK(ListNode *node, int k){

		int i = 1;
		
		ListNode *first = node;
		ListNode *last = node;
		
		while( i < k && last->next){
			ListNode *tmp = last->next;
			last->next = tmp->next;
			tmp->next = first;
			first = tmp;
			i++;
		}
			
		return first;
		
	}

	//get the last element of a group
	ListNode *nextStep(ListNode *node, int k){
		
		int i = 1;
		while(i < k && node){
			node = node->next;
			i++;
		}
		return node;
		
	}


    ListNode *reverseKGroup(ListNode *head, int k) {
 	if(k<=1){
		return head;
	}	

	ListNode *nextNode = nextStep(head,k);
	if(nextNode == NULL)
		return head;
	
	ListNode *newHead = reverseK(head, k);
	nextNode = nextStep(newHead,k);

	while(nextNode->next){
		ListNode *lastPreNode = nextNode;
		nextNode = nextStep(lastPreNode->next,k);
		if(nextNode == NULL)
			return newHead;
		lastPreNode->next = reverseK(lastPreNode->next, k);
		nextNode = nextStep(lastPreNode->next,k);

	}

	return newHead;
    }
};


int _tmain(int argc, _TCHAR* argv[])
{
	//Test case
	


	Solution instance;

	string str("229");

	ListNode *a = new ListNode(1);
	ListNode *b = new ListNode(2);
	ListNode *c = new ListNode(3);
	ListNode *d = new ListNode(4);
	ListNode *e = new ListNode(5);
//	ListNode *f = new ListNode(6);


	a->next = b;
	b->next = c;
	c->next = d;
	d->next = e;

	int arr[] = {1,2,2,3};
	vector<int> vi(arr, arr+4);

	ListNode *iR = instance.reverseKGroup(a, 3);
//	vector<vector<int> > bR = instance.combinationSum2(vi, 1);
//	vector< vector<int> > vvi = instance.subsetsWithDup(vi);
	

	return 0;

}

