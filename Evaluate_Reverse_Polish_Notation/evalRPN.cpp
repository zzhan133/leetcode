#include 	<iostream>
#include	<vector>
#include	<string>
#include	<stack>
#include <stdlib.h> 

using namespace std;

class Solution {
public:
    int evalRPN(vector<string> &tokens) {
		if (tokens.size() < 3)
		{
			if (tokens.size() == 1)
			{
				const char* tmp = tokens[0].c_str();
				return atoi(tmp);
			}
			else
				return -1;
		}
        //iterator the vector from first to last
		stack<int> operands;
		for(unsigned i = 0; i<tokens.size(); i++)
		{
			if(tokens[i] == "+"){
				if(tokens.size() < 2)
					return -1;
				int second_operand = operands.top();
				operands.pop();
				int first_operand = operands.top();
				operands.pop();
				operands.push(first_operand + second_operand);
			}
			else if(tokens[i] == "-"){
				if(tokens.size() < 2)
					return -1;
				int second_operand = operands.top();
				operands.pop();
				int first_operand = operands.top();
				operands.pop();
				operands.push(first_operand - second_operand);
			}
			else if(tokens[i] == "*"){
				if(tokens.size() < 2)
					return -1;
				int second_operand = operands.top();
				operands.pop();
				int first_operand = operands.top();
				operands.pop();
				operands.push(first_operand * second_operand);
			}
			else if(tokens[i] == "/"){
				if(tokens.size() < 2)
					return -1;
				int second_operand = operands.top();
				operands.pop();
				int first_operand = operands.top();
				operands.pop();
				operands.push(first_operand / second_operand);
			}
			else{
				//char* tmp = new char[tokens[i].size()+1];
				const char* tmp = tokens[i].c_str();
				int n = atoi(tmp);
				operands.push(n);
			}
		}
		int results = operands.top();
		return results;
    }
};

int main(){
	string str[] = { "4" };
	vector<string> tokens(str, str+1);
	Solution instance;
	cout<<instance.evalRPN(tokens)<<endl;
	return 0;
	
}

/*  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 */