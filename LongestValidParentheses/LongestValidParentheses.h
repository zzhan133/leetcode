class Solution {
 public:

	 int longestValidParentheses(string s) {
		 stack<char> myStack;
		 stack<unsigned int> posStack;
		 unsigned i = 0;
		 while(i != s.size()){
			 if(s[i] == '('){
				 myStack.push(s[i]);
				 posStack.push(i);
			 }
			 else{
				 if (!myStack.empty() && myStack.top() == '(')
				 {
					 myStack.pop();
					 posStack.pop();
				 }
				 else{
					 myStack.push(s[i]);
					 posStack.push(i);
				 }

			 }
			 i++;
		 }
		 unsigned int maxNum = 0;
		 if (posStack.empty())
		 {
			 return s.size();
		 }
		 unsigned int tmp = s.size();
		 while (!posStack.empty())
		 {

			 if (tmp - posStack.top() - 1 > maxNum)
			 {
				 maxNum = tmp - posStack.top() - 1;
			 }
			 tmp = posStack.top();
			 posStack.pop();
		 }


		 return maxNum > (tmp - 0) ? maxNum : (tmp - 0);

	 }
 };
Longest Valid Parentheses
