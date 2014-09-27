class Solution {
 public:
	 int largestRectangleArea(vector<int> &height) {
		 stack<int> posStack;
		 height.push_back(0);
		 int maxArea = 0;
		 for(unsigned int i = 0; i<height.size(); i++){
			 if(posStack.size() == 0 || height[i] >= height[posStack.top()] )
				 posStack.push(i);
			 else{
				 int tmp = posStack.top();
				 posStack.pop();
				 int dist = posStack.empty() ? i : ( i-posStack.top() -1);
				 maxArea = max(maxArea ,height[tmp] * dist );
				 i--;
			 }
		 }	
		 return maxArea;
	 }
 };

