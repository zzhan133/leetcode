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
	 void getValue(vector<vector<char> > &matrix, int row, vector<int> &viRow){
		 int col = matrix[row].size();
		 for(int i = 0; i < col; i++){
			 if(matrix[row][i] == '0'){
				 viRow[i] = 0;
			 }
			 else{
				 if(viRow[i] != 0)
					 viRow[i]--;
				 else{
					 unsigned j = row;
					 while(j<matrix.size() && matrix[j][i] == '1'){
						 viRow[i]++;
						 j++;
					 }
				 }
			 }
		 }
	 }
	 int maximalRectangle(vector<vector<char> > &matrix) {
		 int maxArea = 0;
		 int row = matrix.size();
		 if(row == 0)
			 return 0;
		 int col = matrix[0].size();
		 if(col == 0)
			 return maxArea;
		 vector<int> viRow(col, 0);
		 //each column as a histgram
		 for(int i = 0; i < row; i++){
			 getValue(matrix, i, viRow);
			 maxArea = max(maxArea, largestRectangleArea(viRow));
		 }
		 return maxArea;
	 }
 };
