#include	<iostream>
#include	<string>
using namespace std;

class Solution {
public:
	bool IsAllSpace(const string& s){
		if(s.size() == 0)
			return true;
		//how to check all the elements of s are ' '
		for(unsigned i = 0; i<s.size();i++){
			if(s[i] != ' ')
				return false;
		}
		return true;
	}
public:
	void RecursiveVersion(string& s, string& store_str, int left_pos, int right_pos){
		if(left_pos > right_pos)
			return;

		//There are words between left_pos and right_pos
		int index = right_pos + 1;
		//delete all spaces on the right side
		while(s[--index] == ' ');  //s[index] != ' ' and index >= left, index<= right
		//delete all space on the left side
	//	left--;
	//	while(s[++left] = ' '); //s[left] != ' ' 
		int pos = index;  //pos is the first pos that is not ' '
		while(index > left_pos && s[--index] != ' '); //s[index] = ' ' or index == left ,but only one since s[left] != ' '
		if(index == left_pos)
		{
			string tmp_str(s, left_pos, pos-left_pos+1);
			store_str = store_str + tmp_str;
			return;
		}
		else
		{
			//s[index] = ' '
			string tmp_str(s, index+1, pos-index);
			store_str = store_str + tmp_str + " ";
			RecursiveVersion(s, store_str, left_pos, index-1);
		}
	}
	void reverseWords(string& s) {
        //1.the cases that can be returned directly
		if(IsAllSpace(s))
		{
			s = "";
			return;
		}

		//s has element that is not ' ';
		int left_pos = -1;
		while(s[++left_pos] == ' ');
		string store_str;
		RecursiveVersion(s, store_str, left_pos, s.size() -1);			
		s = store_str;
		return;
	}
};

int main(){
	string s("the sky is blue");
	cout<<s.size()<<endl;
	Solution instance;
	instance.reverseWords(s);
	cout<<s<<endl;
	cout<<s.size()<<endl;
	return 0;
}
