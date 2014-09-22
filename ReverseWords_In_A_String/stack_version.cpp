#include	<stack>
#include	<iostream>
#include	<string>
using namespace std;

class Solution{
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

	void pushToStack(const string& s, stack<string>& str_stack, int left_pos, int right_pos){
		int index = left_pos-1;
		while(s[++index] == ' ');  //s[index] != ' '
		int pos_backup = index;
		while(index < right_pos && s[++index] != ' ');
		if(index == right_pos)
		{
			string tmp(s, pos_backup, index - pos_backup + 1);
			str_stack.push(tmp);
		}
		else
		{
			string tmp(s, pos_backup, index - pos_backup);
			str_stack.push(tmp);
			pushToStack(s, str_stack, index+1, right_pos);
		}
	}
	
public:
	void reverseWords(string& s){
		if(IsAllSpace(s))
		{
			s = "";
			return;
		}

		//s has element that is not ' ';
		int right_pos = s.size();
		while(s[--right_pos] == ' ');
		stack<string> str_stack;
		pushToStack(s, str_stack, 0, right_pos);
		s.clear();
		while(!str_stack.empty()){
			s = s+str_stack.top() + " ";
			str_stack.pop();
		}
		s.erase(s.size()-1,1);
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

